import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IManpadExt } from 'src/app/interfaces/imanpad-ext';

@Component({
  selector: 'app-stock-section',
  templateUrl: './stock-section.component.html',
  styleUrls: ['./stock-section.component.scss']
})
export class StockSectionComponent implements OnInit {
  @Input() stock_items!:IManpadExt[];
  @Output() public deleteClicked: EventEmitter<IManpadExt> = new EventEmitter<IManpadExt>();
  constructor() { }

  ngOnInit(): void {
  }
  deleteItem(item:IManpadExt)
  {
    this.deleteClicked.emit(item);
  }
}
