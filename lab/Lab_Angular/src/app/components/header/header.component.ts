import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  searchToggleStatus : boolean = false;
  navbarToggleStatus : boolean = false;
  constructor() { }

  ngOnInit(): void {
  }
  searchToggle(event: MouseEvent){
    this.searchToggleStatus = !this.searchToggleStatus;
    this.navbarToggleStatus = false;
  }
  navbarToggle(event: MouseEvent){
    this.navbarToggleStatus = !this.navbarToggleStatus;
    this.searchToggleStatus = false;
    
    // if (header.style.backgroundColor != 'var(--main-color)') {
    //     header.style.backgroundColor = 'var(--main-color)';
    // }
    // else {
    //     header.style.backgroundColor = null;
    // }
  }
}
