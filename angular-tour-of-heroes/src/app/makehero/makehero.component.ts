import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-makehero',
  templateUrl: './makehero.component.html',
  styleUrls: ['./makehero.component.scss']
})
export class MakeheroComponent implements OnInit {

  form: FormGroup;

  constructor(@Inject(FormBuilder) fb: FormBuilder) {
    this.form = fb.group({
      email: [null]
      , password: [null]
      , lang: [null]
      , privacyAndPolicy: [false]
    });
    console.log('ts');
  }

  ngOnInit() {
  }

  submitHandler(value) {
    console.log(value);
  }

}
