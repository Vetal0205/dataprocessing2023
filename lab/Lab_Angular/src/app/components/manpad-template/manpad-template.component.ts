import { Component, Input, OnInit } from '@angular/core';
import { IManpad } from 'src/app/interfaces/imanpad';

@Component({
  selector: 'app-manpad-template',
  templateUrl: './manpad-template.component.html',
  styleUrls: ['./manpad-template.component.scss']
})
export class ManpadTemplateComponent implements OnInit {
  @Input() manpad!: IManpad;
  constructor() { }

  ngOnInit(): void {
  }

}
