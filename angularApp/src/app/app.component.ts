import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {DatabaseTest, Greeting} from "YoutrackKotlinJs-shared";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'angularApp';

  async ngOnInit() {
    new Greeting().greet()
    await DatabaseTest.Companion.initDatabase()
    const databaseTest = DatabaseTest.Companion.getInstance()

    console.log(databaseTest.getTests())
  }
}
