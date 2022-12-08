import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { SubQnAModel } from 'src/app/subQnA/subQnA-response';
import { Router } from '@angular/router';
import { PostService } from 'src/app/shared/post.service';
import { SubQnAService } from 'src/app/subQnA/subQnA.service';
import { throwError } from 'rxjs';
import { CreatePostPayload } from './create-post.payload';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  createPostForm: FormGroup;
  postPayload: CreatePostPayload;
  subQnAs: Array<SubQnAModel>;

  constructor(private router: Router, private postService: PostService,
    private subQnAService: SubQnAService) {
    this.postPayload = {
      postName: '',
      url: '',
      description: '',
      subQnAName: ''
    }
  }

  ngOnInit() {
    this.createPostForm = new FormGroup({
      postName: new FormControl('', Validators.required),
      subQnAName: new FormControl('', Validators.required),
      url: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
    });
    this.subQnAService.getAllSubQnAs().subscribe((data) => {
      this.subQnAs = data;
    }, error => {
      throwError(error);
    });
  }

  createPost() {
    this.postPayload.postName = this.createPostForm.get('postName').value;
    this.postPayload.subQnAName = this.createPostForm.get('subQnAName').value;
    this.postPayload.url = this.createPostForm.get('url').value;
    this.postPayload.description = this.createPostForm.get('description').value;

    this.postService.createPost(this.postPayload).subscribe((data) => {
      this.router.navigateByUrl('/');
    }, error => {
      throwError(error);
    })
  }

  discardPost() {
    this.router.navigateByUrl('/');
  }

}
