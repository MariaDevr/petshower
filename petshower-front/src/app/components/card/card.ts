import { Component, Input } from '@angular/core';
import { MatCardModule, MatCardContent, MatCardTitle } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [MatCardModule,MatCardContent,MatCardTitle,MatIconModule],
  templateUrl: './card.html',
  styleUrl: './card.scss',
})
export class Card {
  appearance: "filled" = "filled";
  @Input({ required: true }) content: string = '';
  @Input() title: string='';
  @Input() icon: string = '';
}
