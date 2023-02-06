import { Component, OnInit, OnDestroy, Output, EventEmitter, Input } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { throttleTime } from 'rxjs';
import { IManpad } from 'src/app/interfaces/imanpad';

@Component({
  selector: 'put-request-form',
  templateUrl: 'put-request-form.component.html',
  styleUrls: ['put-request-form.component.scss'],
})
export class PutRequestFormComponent implements OnInit, OnDestroy {
  public formGroup!: FormGroup;
  public model: IManpad = { name: "Blowpipe", weight: 2.2, photo: "./assets/img/blowpipe.png" };
  @Output() public onChange: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public onInit: EventEmitter<FormGroup> = new EventEmitter<FormGroup>();
  @Output() public putRequest: EventEmitter<IManpad> = new EventEmitter<IManpad>();

  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.initForm();
    this.formGroup.valueChanges.subscribe(formData => {
      this.onChange.emit(this.formGroup);
    });
    this.onInit.emit(this.formGroup);
  }

  private initForm() {
    this.formGroup = this.fb.group({
      name: [
        this.model.name,
        [Validators.required,


        ]
      ],


      weight: [
        this.model.weight,
        [Validators.required,


        ]
      ],


      photo: [
        this.model.photo,
        [Validators.required,


        ]
      ],



    });
  }
  // convenience getter for easy access to form fields
  get f(): any {
    return this.formGroup.controls;
  }

  addItem(formArrayName: string) {
    this.f[formArrayName].push(this.fb.control(''));
  }

  deleteItem(formArrayName: string, index: number) {
    this.f[formArrayName].removeAt(index);
  }
  onSubmit() {
    if (this.formGroup.invalid == false) {
      this.model.name = this.f['name'].value;
      this.model.weight = this.f['weight'].value;
      this.model.photo = this.f['photo'].value;
      this.putRequest.emit(this.model);
    }
  }

  ngOnDestroy() {

  }
}
