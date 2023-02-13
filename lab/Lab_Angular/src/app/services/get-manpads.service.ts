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
  private apiurl:string = "http://localhost:8080/Lab_dp/manpads";
  constructor(private http:HttpClient) { }

  getItems():Observable<IManpad[]>{
    return this.http.get<IManpad[]>(this.apiurl);
  }
  putManpad(body:IManpad):Observable<IManpad[]>{
    return this.http.put<IManpad[]>(this.apiurl + "/" + body.id, body)
  }
  delManpad(body:IManpad):Observable<IManpad[]>{
    return this.http.delete<IManpad[]>(this.apiurl + "/" + body.id)
  }
  postManpad(body:IManpad):Observable<IManpad>{
    return this.http.post<IManpad>(this.apiurl, body)
  }
}
