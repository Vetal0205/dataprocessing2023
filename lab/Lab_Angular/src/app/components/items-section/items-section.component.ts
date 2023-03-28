import { Component, OnInit } from '@angular/core';
import { IManpad } from 'src/app/interfaces/imanpad';
import { IManpadExt } from 'src/app/interfaces/imanpad-ext';
import { GetManpadsService } from 'src/app/services/get-manpads.service';

@Component({
  selector: 'app-items-section',
  templateUrl: './items-section.component.html',
  styleUrls: ['./items-section.component.scss']
})
export class ItemsSectionComponent implements OnInit {

  constructor(private service: GetManpadsService) { }
  Manpads!: IManpad[];
  selectedManpad?: IManpad;

  stockItems:IManpadExt[] = [];

  showPOSTform: boolean = true;
  showPUTform: boolean = false;

  ngOnInit(): void {
    this.getManpad();
  }
  getStockItem(manpad:IManpadExt){
    this.stockItems.push(manpad);
  }
  onSelect(manpad: IManpad) {
    if (this.selectedManpad && manpad.id == this.selectedManpad.id) {
      this.selectedManpad = undefined;
      this.showPUTform = false;
    }
    else {
      this.selectedManpad = manpad;
      this.showPUTform = true;
    }
  }
  getManpad() {
    this.service.getManpads().subscribe((manpads) => {
      this.Manpads = manpads;
      if (this.Manpads.length == 0 && this.showPUTform == true) {
        this.showPUTform = false;
        this.selectedManpad = undefined;

      }
    });
  }
  deleteItem(item:IManpadExt)
  {
    this.stockItems = this.stockItems.filter(obj => obj.id !== item.id);
  }

  postRequest(body: {manpad:IManpad, hibernate:boolean}) {
    this.service.postManpad(body.manpad, body.hibernate).subscribe(() => { alert("POST request has been sent!"); this.getManpad(); })
  }
  putRequest(body: {manpad:IManpad, hibernate:boolean}) {
    this.service.putManpad(body.manpad, body.hibernate).subscribe(() => { alert("PUT request has been sent!"); this.getManpad(); })
  }
  deleteRequest(body:{manpad:IManpad, hibernate:boolean}) {
    this.service.delManpad(body.manpad, body.hibernate).subscribe(() => {
      alert("DELETE request has been sent!");
      this.getManpad();
    })
  }
}
