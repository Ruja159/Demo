import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { JwtClientService } from '../jwt-client.service';
import { UsersList } from '../usersList';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})



export class TableComponent implements OnInit {
  userList: any;


  displayedColumns: string[] = ['id', 'name', 'lastName', 'email'];
  dataSource: MatTableDataSource<[any]>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: JwtClientService) {

  }
  ngOnInit() {
    this.service.getUsers().subscribe((data: any) => {
      this.userList = JSON.parse(data);
      console.log(this.userList)
      console.log(typeof this.userList)
      this.dataSource = new MatTableDataSource(this.userList);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      console.log(this.dataSource)
    });  
  }


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}

