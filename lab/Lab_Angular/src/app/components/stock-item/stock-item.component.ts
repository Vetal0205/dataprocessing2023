import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IManpadExt } from 'src/app/interfaces/imanpad-ext';

@Component({
  selector: 'app-stock-item',
  templateUrl: './stock-item.component.html',
  styleUrls: ['./stock-item.component.scss']
})
export class StockItemComponent implements OnInit {
  @Input() stock_item!:IManpadExt;
  @Output() public deleteClicked: EventEmitter<IManpadExt> = new EventEmitter<IManpadExt>();
  constructor() { }
  
  ngOnInit(): void {
  }
  deleteItem(item:IManpadExt)
  {
    this.deleteClicked.emit(item);
  }
}
