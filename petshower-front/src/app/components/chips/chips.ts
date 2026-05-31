import { Component, Input } from '@angular/core';
import { MatChipsModule } from '@angular/material/chips';

@Component({
  selector: 'app-chips',
  standalone: true,
  imports: [MatChipsModule],
  templateUrl: './chips.html',
  styleUrls: ['./chips.scss'],
})
export class Chips {
  @Input() color: 'success' | 'info' | 'warning' | 'danger' = 'success';
  @Input() value: string = '';
}