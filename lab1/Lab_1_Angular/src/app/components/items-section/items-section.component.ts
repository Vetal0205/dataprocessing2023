import { Component, OnInit } from '@angular/core';
import { IManpad } from 'src/app/interfaces/imanpad';
import { GetManpadsService } from 'src/app/services/get-manpads.service';

@Component({
  selector: 'app-items-section',
  templateUrl: './items-section.component.html',
  styleUrls: ['./items-section.component.scss']
})
export class ItemsSectionComponent implements OnInit {

  constructor(private service: GetManpadsService) { }
  Manpads:IManpad =  {name:"Blowpipe", weight:2.2, photo:"./assets/img/blowpipe.png"};
  // Manpads:IManpad[] = [];
  ngOnInit(): void {
    this.getManpad();
  }
  getManpad(){
    this.service.getItems().subscribe((manpads) => { this.Manpads = manpads; console.log(manpads)});
  }
  putRequest(body:IManpad){
    this.service.putManpad(body).subscribe(()=>{alert("PUT request has been sent!"); this.getManpad();})
    
  }
}
