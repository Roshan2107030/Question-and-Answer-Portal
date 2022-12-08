import { Component, OnInit } from '@angular/core';
import { SubQnAService } from 'src/app/subQnA/subQnA.service';
import { SubQnAModel } from 'src/app/subQnA/subQnA-response';

@Component({
  selector: 'app-subQnA-side-bar',
  templateUrl: './subQnA-side-bar.component.html',
  styleUrls: ['./subQnA-side-bar.component.css']
})
export class SubQnASideBarComponent implements OnInit {
  subQnAs: Array<SubQnAModel> = [];
  displayViewAll: boolean | undefined;

  constructor(private subQnAService: SubQnAService) {
    this.subQnAService.getAllSubQnAs().subscribe(data => {
      if (data.length > 3) {
        this.subQnAs = data.splice(0, 3);
        this.displayViewAll = true;
      } else {
        this.subQnAs = data;
      }
    });
  }

  ngOnInit(): void { }

}
