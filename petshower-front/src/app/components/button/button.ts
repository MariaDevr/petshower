import { Component, Input } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [MatButtonModule],
  templateUrl: './button.html',
  styleUrl: './button.scss',
})
export class ButtonComponent {

  @Input() appearance: 'fill' | 'text' = 'fill';
  @Input() color: string = 'primary';
  @Input() label: string = 'Clique aqui';
}
