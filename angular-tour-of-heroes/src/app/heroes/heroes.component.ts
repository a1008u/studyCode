import { Component, OnInit } from '@angular/core';
import {Hero} from '../dto/hero';
import {HeroService} from '../service/hero.service';


@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.scss']
})
export class HeroesComponent implements OnInit {
  heroes: Hero[];

  constructor(private heroService: HeroService) { }

  ngOnInit() {
    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService
      .getHeroes()
      .subscribe(heroes => this.heroes = heroes);
  }

  add(name: string): void {
    const trimName: string = name.trim();
    if (!trimName) { return; }
    this.heroService
      .addHero({ name } as Hero)
      .subscribe(hero => {this.heroes.push(hero); });
  }

  /**
   * 処理の流れ
   * 1.配列から該当するもの以外を配列として返す
   * 2.該当するheroを削除する
   * @param {Hero} hero
   */
  delete(hero: Hero): void {
    this.heroes = this.heroes.filter(h => h !== hero);
    this.heroService
      .deleteHero(hero)
      .subscribe();
  }

}
