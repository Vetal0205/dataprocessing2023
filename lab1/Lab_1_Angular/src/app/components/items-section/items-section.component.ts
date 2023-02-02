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
  Manpads:IManpad[] = [];
  ngOnInit(): void {
    this.service.getItems().subscribe((manpads) => { this.Manpads = manpads; console.log(manpads)});
  }

}
