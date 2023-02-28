import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IManpad } from 'src/app/interfaces/imanpad';
import { IManpadExt } from 'src/app/interfaces/imanpad-ext';

@Component({
  selector: 'app-manpad-template',
  templateUrl: './manpad-template.component.html',
  styleUrls: ['./manpad-template.component.scss']
})
export class ManpadTemplateComponent implements OnInit {
  @Input() manpad!: IManpad;
  @Output() public deleteClicked: EventEmitter<{manpad:IManpad, hibernate:boolean}> = new EventEmitter<{manpad:IManpad, hibernate:boolean}>();
  @Output() public selectClicked: EventEmitter<IManpad> = new EventEmitter<IManpad>();
  @Output() public addButtonClicked: EventEmitter<IManpadExt> = new EventEmitter<IManpadExt>();
  constructor() { }

  newStockItem!:IManpadExt;
  inputValue:number = 0;

  ngOnInit(): void {
  }
  deleteClick(click: {manpad:IManpad, hibernate:boolean}){
    this.deleteClicked.emit(click);
  }
  onSelect(manpad:IManpad){
    this.selectClicked.emit(manpad);
  }
  quantityChangedItemsMinus(event: MouseEvent){
    if(this.inputValue != 0){
      this.inputValue--;
    }
  }
  quantityChangedItemsPlus(event: MouseEvent){this.inputValue++;}

  addToStock(manpad:IManpad){
    if (this.inputValue > 0){
      this.newStockItem = {...manpad, amount: this.inputValue}
      this.addButtonClicked.emit(this.newStockItem);
    } 
  }
}
