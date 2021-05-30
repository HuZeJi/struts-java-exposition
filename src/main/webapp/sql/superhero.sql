/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  vhjim
 * Created: May 30, 2021
 */

create table `superhero` (
    `id` varchar(25) not null,
    `s_name` varchar(50) default null,
    `superpower` varchar(50) default null,
    `r_name` varchar(50) default null,
    `editorial` varchar(50) default null,
    `history` varchar(255) default null,
    primary key(`id`)
);
