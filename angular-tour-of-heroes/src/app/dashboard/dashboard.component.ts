import { Component, OnInit } from '@angular/core';
import { Hero } from '../dto/hero';
import { HeroService } from '../service/hero.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.scss' ]
})
export class DashboardComponent implements OnInit {
  heroes: Hero[] = [];

  constructor(private heroService: HeroService
              , private http: HttpClient) { }

  ngOnInit() {
    this.getHeroes();

    // in-memoryを利用していると利用できない .get<sample>('https://jsonplaceholder.typicode.com/comments/1')
    // this.http
    //   .get<User[]>('http://127.0.0.1:8081/ListUsers')
    //   .subscribe(
    //     next =>  {
    //           console.log(next);
    //         }
    //      , error => {
    //           console.log(error);
    //           console.log('nooooooooo');
    //         }
    //   , () => console.log('ddddddone'));
  }

  getHeroes(): void {
    this.heroService
      .getHeroes()
      .subscribe(heroes => {
        this.heroes = heroes.slice(1, 5);
      });
  }

}

interface User {
  name: string;
  password: string;
  profession: Profession;
  id: number;
}

interface Profession {
  type1: string;
  type2: string;
}


