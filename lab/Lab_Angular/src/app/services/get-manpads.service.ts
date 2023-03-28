import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IManpad } from '../interfaces/imanpad';
import { HttpResponseLab_dp } from '../interfaces/rest-repository-resource/http-response';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root'
})
export class GetManpadsService {
  private apiurl:string = "http://localhost:8080/Lab_dp";
  constructor(private http:HttpClient) { }

  getItems():Observable<HttpResponseLab_dp>{
    return this.http.get<HttpResponseLab_dp>(this.apiurl);
  }
  putManpad(body:IManpad, hibernate:boolean):Observable<IManpad[]>{
    return this.http.put<IManpad[]>(this.apiurl + `/${body.id}`, body)
  }
  delManpad(body:IManpad, hibernate:boolean):Observable<IManpad[]>{
    return this.http.delete<IManpad[]>(this.apiurl + `/${body.id}`)
  }
  postManpad(body:IManpad, hibernate:boolean):Observable<IManpad>{
    return this.http.post<IManpad>(this.apiurl, body)
  }
}
