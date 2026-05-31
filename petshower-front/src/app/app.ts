import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ButtonComponent } from '../app/components/button/button';
import { Card } from '../app/components/card/card';
import { Chips } from '../app/components/chips/chips';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ButtonComponent,Card, Chips],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('petshower-front');
}
