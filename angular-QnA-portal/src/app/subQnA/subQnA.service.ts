import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SubQnAModel } from './subQnA-response';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubQnAService {
  constructor(private http: HttpClient) { }

  getAllSubQnAs(): Observable<Array<SubQnAModel>> {
    return this.http.get<Array<SubQnAModel>>('http://localhost:8080/api/subQnA');
  }

  createSubQnA(subQnAModel: SubQnAModel): Observable<SubQnAModel> {
    return this.http.post<SubQnAModel>('http://localhost:8080/api/subQnA',
      subQnAModel);
  }
}
