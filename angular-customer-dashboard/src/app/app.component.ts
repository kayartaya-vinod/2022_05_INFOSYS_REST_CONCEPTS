import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  customers: Array<any> = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:1234/api/customers')
      .subscribe(this.handler)
  }

  handler = {
    next: (data: any) => {
      this.customers = data.customers
    }
  }
}
