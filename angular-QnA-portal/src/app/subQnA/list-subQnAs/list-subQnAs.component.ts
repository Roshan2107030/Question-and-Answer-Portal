import { Component, OnInit } from '@angular/core';
import { SubQnAModel } from '../subQnA-response';
import { SubQnAService } from '../subQnA.service';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-list-subQnAs',
  templateUrl: './list-subQnAs.component.html',
  styleUrls: ['./list-subQnAs.component.css']
})
export class ListSubQnAsComponent implements OnInit {

  subQnAs: Array<SubQnAModel> | undefined;
  constructor(private subQnAService: SubQnAService) { }

  ngOnInit() {
    this.subQnAService.getAllSubQnAs().subscribe(data => {
      this.subQnAs = data;
    }, error => {
      throwError(error);
    })
  }
}