import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeheroComponent } from './makehero.component';

describe('MakeheroComponent', () => {
  let component: MakeheroComponent;
  let fixture: ComponentFixture<MakeheroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeheroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeheroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
