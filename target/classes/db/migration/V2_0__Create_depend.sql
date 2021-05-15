ALTER TABLE `recept`.`product`
ADD CONSTRAINT `category_p`
  FOREIGN KEY (`category`)
  REFERENCES `recept`.`product_category` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `recept`.`dish`
ADD CONSTRAINT `category`
  FOREIGN KEY (`category`)
  REFERENCES `recept`.`dish_category` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `recept`.`recipe`
ADD INDEX `product_idx` (`product_id` ASC) VISIBLE;
;
ALTER TABLE `recept`.`recipe`
ADD CONSTRAINT `dish`
  FOREIGN KEY (`dish_id`)
  REFERENCES `recept`.`dish` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `product`
  FOREIGN KEY (`product_id`)
  REFERENCES `recept`.`product` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `recept`.`dish_set`
ADD INDEX `dish_set_idx` (`dish_id` ASC) VISIBLE;
;
ALTER TABLE `recept`.`dish_set`
ADD CONSTRAINT `menu_dish`
  FOREIGN KEY (`menu_id`)
  REFERENCES `recept`.`menu` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `dish_set`
  FOREIGN KEY (`dish_id`)
  REFERENCES `recept`.`dish` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `recept`.`product_set`
ADD INDEX `product_set_idx` (`product_id` ASC) VISIBLE;
;
ALTER TABLE `recept`.`product_set`
ADD CONSTRAINT `menu_product`
  FOREIGN KEY (`menu_id`)
  REFERENCES `recept`.`menu` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `product_set`
  FOREIGN KEY (`product_id`)
  REFERENCES `recept`.`product` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;