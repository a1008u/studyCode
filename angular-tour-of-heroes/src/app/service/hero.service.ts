import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { MessageService } from './message.service';
import {Hero} from '../dto/hero';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class HeroService {

  private heroesUrl = 'api/heroes'; // Web APIのURL

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }

  /**
   * サーバーからヒーローを取得する
   * observableの結果をpipe()で拡張して、エラーハンドリングを行う
   */
  getHeroes (): Observable<Hero[]> {
    const urlnode = 'http://127.0.0.1:8082/ListUsers';
    return this.http
      .get<Hero[]>(urlnode)
      .pipe(
        tap(heroes => this.log(`fetched heroes`))
        , catchError(this.handleError('getHeroes', []))
      );
  }

  /**
   * IDによりヒーローを取得する。
   * idが見つからない場合は`undefined`を返す。
   */
  getHeroNo404<Data>(id: number): Observable<Hero> {
    const url = `${this.heroesUrl}/?id=${id}`;
    const urlnode = 'http://127.0.0.1:8082/listUsers';
    return this.http
      .get<Hero[]>(urlnode)
      .pipe(
        map(heroes => heroes[0]), // {0|1} 要素の配列を返す
        tap(h => {
          const outcome = h ? `fetched` : `did not find`;
          this.log(`${outcome} hero id=${id}`);
        }),
        catchError(this.handleError<Hero>(`getHero id=${id}`))
      );
  }

  /**
   * IDによりヒーローを取得する。
   * 見つからなかった場合は404を返却する。
   *
   * 要件
   * 1.求めたいヒーローのIDを含んだURLを生成すること。
   * 2.サーバーは一人のヒーローの情報を返す必要があること。
   * 3.getHeroはヒーローの配列のObservableを返すのではなく、 Observable<Hero> (ヒーローオブジェクトのObservable)を返すこと。
   */
  getHero(id: number): Observable<Hero> {
    const url = `${this.heroesUrl}/${id}`;
    const urlnode = `http://127.0.0.1:8082/User/${id}`;
    return this.http
      .get<Hero>(urlnode)
      .pipe(
        tap(_ => this.log(`fetched hero id=${id}`))
        , catchError(this.handleError<Hero>(`getHero id=${id}`))
    );
  }

  /**
   * 検索語を含むヒーローを取得する
   */
  searchHeroes(term: string): Observable<Hero[]> {

    const urlnode = `http://127.0.0.1:8082/Users/${term}`;
    const url = `api/heroes/?name=${term}`;

    // 検索語がない場合、空のヒーロー配列を返す
    if (!term.trim()) { return of([]); }

    return this.http
      .get<Hero[]>(urlnode)
      .pipe(
        tap(_ => this.log(`found heroes matching "${term}"`)),
        catchError(this.handleError<Hero[]>('searchHeroes', []))
    );
  }

  //////// Save methods //////////

  /** POST: サーバーに新しいヒーローを登録する
   *
   * updateHeroとの違い
   * 1.put()の代わりにHttpClient.post()を呼び出します。
   * 2.サーバーで新しいヒーローのIDが生成されることを期待します。そしてそれは呼び出し元にObservable<Hero>として戻ります
   */
  addHero (hero: Hero): Observable<Hero> {
    return this.http
      .post<Hero>(this.heroesUrl, hero, httpOptions)
      .pipe(
        tap((unhero: Hero) => this.log(`added hero w/ id=${unhero.id}`))
        , catchError(this.handleError<Hero>('addHero'))
    );
  }

  /**
   * DELETE: サーバーからヒーローを削除
   * 引数として、Hero型かnumber型を受け取れるようにする
   */
  deleteHero (hero: Hero | number): Observable<Hero> {
    const id = typeof hero === 'number' ? hero : hero.id;
    const url = `${this.heroesUrl}/${id}`;

    return this.http
      .delete<Hero>(url, httpOptions)
      .pipe(
        tap(_ => this.log(`deleted hero id=${id}`))
        , catchError(this.handleError<Hero>('deleteHero'))
    );
  }

  /**
   * PUT: サーバー上でヒーローを更新
   * putの引数
   * 1.URL
   * 2.アップデート用のデータ (今回の場合は編集されたヒーロー)
   * 3.オプション(httpのヘッダーオプションを設定)
   */
  updateHero (hero: Hero): Observable<any> {
    return this.http
      .put(this.heroesUrl, hero, httpOptions)
      .pipe(
        tap(_ => this.log(`updated hero id=${hero.id}`))
        , catchError(this.handleError<any>('updateHero'))
    );
  }

  /**
   * 失敗したHttp操作を処理します。
   * アプリを持続させます。
   * @param operation - 失敗した操作の名前
   * @param result - observableな結果として返す任意の値
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: リモート上のロギング基盤にエラーを送信する
      console.error(error); // かわりにconsoleに出力

      // TODO: ユーザーへの開示のためにエラーの変換処理を改善する
      this.log(`${operation} failed: ${error.message}`);

      // 空の結果を返して、アプリを持続可能にする
      return of(result as T);
    };
  }

  /** HeroServiceのメッセージをMessageServiceを使って記録 */
  private log(message: string) {
    this.messageService.add('HeroService: ' + message);
  }
}
