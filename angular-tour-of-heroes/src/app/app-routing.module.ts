import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { MakeheroComponent } from './makehero/makehero.component';

const routes: Routes = [
  // デフォルトルートを設定する
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' }
  , { path: 'dashboard', component: DashboardComponent }
  , { path: 'detail/:id', component: HeroDetailComponent }
  , { path: 'heroes', component: HeroesComponent }
  , { path: 'makehero', component: MakeheroComponent }
];

@NgModule({
  exports: [ RouterModule ]
  , imports: [ RouterModule.forRoot(routes) ] // ルーターの初期化 + ルーターにブラウザのロケーション変化の検知をさせる
})
export class AppRoutingModule { }
