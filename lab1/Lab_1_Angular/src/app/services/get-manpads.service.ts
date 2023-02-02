import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IManpad } from '../interfaces/imanpad';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class GetManpadsService {
  private apiurl:string = "http://localhost:8080/Lab_1_dp/";
  constructor(private http:HttpClient) { }

  getItems():Observable<IManpad[]>{
    const url = `${this.apiurl}manpads`
    return this.http.get<IManpad[]>(url);
  }
}
