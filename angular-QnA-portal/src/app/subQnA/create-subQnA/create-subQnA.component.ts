import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SubQnAModel } from '../subQnA-response';
import { Router } from '@angular/router';
import { SubQnAService } from '../subQnA.service';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-create-subQnA',
  templateUrl: './create-subQnA.component.html',
  styleUrls: ['./create-subQnA.component.css']
})
export class CreateSubQnAComponent implements OnInit {
createSubQna() {
throw new Error('Method not implemented.');
}
  createSubQnAForm: FormGroup;
  subQnAModel: SubQnAModel;
  title = new FormControl('');
  description = new FormControl('');

  constructor(private router: Router, private subQnAService: SubQnAService) {
    this.createSubQnAForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required)
    });
    this.subQnAModel = {
      name: '',
      description: ''
    }
  }

  ngOnInit() {
  }

  discard() {
    this.router.navigateByUrl('/');
  }

  createSubQnA() {
    this.subQnAModel.name = this.createSubQnAForm.get('title')
    .value;
    this.subQnAModel.description = this.createSubQnAForm.get('description')
    .value;
    this.subQnAService.createSubQnA(this.subQnAModel).subscribe(data => {
      this.router.navigateByUrl('/list-subQnAs');
    }, error => {
      throwError(error);
    })
  }
}
