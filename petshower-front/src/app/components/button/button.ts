import { Component, Input } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [MatButtonModule, MatIconModule],
  templateUrl: './button.html',
  styleUrl: './button.scss',
})
export class ButtonComponent {

  @Input({ required: true }) appearance: 'fill' | 'text' = 'fill';
  @Input({ required: true }) size : 'regular' | 'large'= 'regular';
  @Input() color: string = 'primary';
  @Input({ required: true }) label: string = 'Clique aqui';
  @Input() icon: string = '';

}
