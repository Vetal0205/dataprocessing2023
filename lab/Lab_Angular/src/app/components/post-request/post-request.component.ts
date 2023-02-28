import { Component, OnInit, OnDestroy, Output, EventEmitter, Input } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { throttleTime } from 'rxjs';
import { IManpad } from 'src/app/interfaces/imanpad';


@Component({
  selector: 'app-post-request',
  templateUrl: './post-request.component.html',
  styleUrls: ['./post-request.component.scss']
})
export class PostRequestComponent implements OnInit,  OnDestroy {

  public PostFormGroup!:FormGroup;
  public model: IManpad = {id:0, name:"Javelin", weight:2.2, photo:"./assets/img/javelin.png"};
  @Output() public onChange: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public onInit: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public postRequest:EventEmitter<{manpad:IManpad, hibernate:boolean}> = new EventEmitter<{manpad:IManpad, hibernate:boolean}>();

  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.initForm();
    this.PostFormGroup.valueChanges.subscribe(() => {
      this.onChange.emit(this.PostFormGroup);
    });
    this.onInit.emit(this.PostFormGroup);
  }

  private initForm() {
    this.PostFormGroup = this.fb.group({
      name: [
        this.model.name,
        [Validators.required,]],
      weight: [
        this.model.weight,
        [Validators.required,]],
      photo: [
        this.model.photo,
        [Validators.required,]],
      hibernate: false,
    });
  }
  // convenience getter for easy access to form fields
  get f(): any {
    return this.PostFormGroup.controls;
  }

  addItem(formArrayName: string) {
    this.f[formArrayName].push(this.fb.control(''));
  }

  deleteItem(formArrayName: string, index: number) {
    this.f[formArrayName].removeAt(index);
  }
  onSubmit() {
    if (this.PostFormGroup.invalid == false) {
      this.model.name = this.f['name'].value;
      this.model.weight = this.f['weight'].value;
      this.model.photo = this.f['photo'].value;
      this.postRequest.emit({manpad:this.model, hibernate:this.f['hibernate'].value });
    }
  }

  ngOnDestroy() {

  }
}
