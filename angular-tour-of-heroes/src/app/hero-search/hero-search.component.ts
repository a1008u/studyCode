import { Component, OnInit } from '@angular/core';

import {debounceTime, distinctUntilChanged, switchMap} from 'rxjs/operators';
import {Observable} from 'rxjs/Observable';
import {Hero} from '../dto/hero';
import {Subject} from 'rxjs/Subject';
import {HeroService} from '../service/hero.service';

@Component({
  selector: 'app-hero-search',
  templateUrl: './hero-search.component.html',
  styleUrls: [ './hero-search.component.scss' ]
})
export class HeroSearchComponent implements OnInit {
  heroes$: Observable<Hero[]>;
  private searchTerms = new Subject<string>();

  constructor(private heroService: HeroService) {}

  // 検索語をobservableストリームにpushする
  search(term: string): void {
    this.searchTerms.next(term);
  }

  /**
   * ngOnInit()メソッドがsearchTermsobservableをsearchHeroes()を呼ぶ回数を抑えるためのいくつかのRxJSオペレーターをつなげていて、
   * 最終的にヒーローのタイムリーな検索結果のobservable(それぞれはHero[])を返します。
   *
   * pipe引数の説明
   * 1.各キーストロークの後、検索前に300ms待つ
   * 2.直前の検索語と同じ場合は無視する
   * 3.検索語が変わる度に、新しい検索observableにスイッチする
   */
  ngOnInit(): void {
    this.heroes$ = this.searchTerms
      .pipe(
        debounceTime(300)
        , distinctUntilChanged()
        , switchMap((term: string) => this.heroService.searchHeroes(term))
      );
  }
}
