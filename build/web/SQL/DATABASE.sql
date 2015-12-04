CREATE DATABASE IF NOT EXISTS renewenergy;

USE renewenergy;

DROP TABLE IF EXISTS `renewenergy`.`order_items`;
DROP TABLE IF EXISTS `renewenergy`.`orders`;
DROP TABLE IF EXISTS `renewenergy`.`productbase`;
DROP TABLE IF EXISTS `renewenergy`.`users`;

/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  PRODUCT BASE
 *  ================================================================================================================== 
 *  ================================================================================================================== */
/*  ------------------------------------------------------------------------------
 *  TABLE:      PRODUCTBASE
 *  NOTE (1):   Serves as the base table for categories, products & services for 
 *              which views will be created for each. 
 *  NOTE (2):   These views will be UPDATEABLE.
 *  NOTE (3):   This table will have a RECURSIVE RELATIONSHIP between the 'id'
 *              column and the 'cat_id' column, 'ALTER TABLE' will have to be used.        
 *  NOTE (4):   Categories will serve as the parent relation for products & services.
 *  ------------------------------------------------------------------------------ */
CREATE TABLE IF NOT EXISTS `renewenergy`.`productbase` (
    `id`                INT                 NOT NULL        AUTO_INCREMENT,
    `cat_id`            INT                 NOT NULL,
    `product_type`      TINYINT             NOT NULL,
    `name`              VARCHAR(50)         NOT NULL,
    `introduction`      VARCHAR(500)        NULL            DEFAULT NULL,
    `overview`          VARCHAR(2500)       NOT NULL,
    `overview_image`    VARCHAR(60)         NOT NULL,
    `banner_image`      VARCHAR(60)         NOT NULL,
    `listitem_image`    VARCHAR(60)         NOT NULL,
    `how_image`         VARCHAR(60)         NULL            DEFAULT NULL,
    `brochure_file`     VARCHAR(60)         NULL            DEFAULT NULL,
    `faqs_file`         VARCHAR(60)         NULL            DEFAULT NULL,
    `video_url`         VARCHAR(100)        NULL            DEFAULT NULL,
    `savings_text`      VARCHAR(150)        NULL            DEFAULT NULL,
    `savings_values`    VARCHAR(50)         NULL            DEFAULT NULL,
    `price`             DECIMAL(8,2)        NOT NULL        DEFAULT '0.00',
    `on_hand`           INT(11)             NOT NULL        DEFAULT '0',
    `last_updated`      TIMESTAMP           NOT NULL        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT `pk_product_id` PRIMARY KEY (`id`),
    CONSTRAINT `uq_product_name` UNIQUE KEY (`name`),
    INDEX `idx_product_category` (`cat_id`)
    /* RECURSIVE RELATIONSHIP SET BELOW */
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
;


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  PRODUCT BASE ALTERATIONS
 *  NOTE:   WE NEED TO ADD A RECORD FIRST (A DUMMY CATEGORY), BEFORE ADDING THE RECURSIVE RELATIONSHIP.
 *  ================================================================================================================== 
 *  ================================================================================================================== */

INSERT INTO `renewenergy`.`productbase` (cat_id,product_type,name,overview,overview_image,banner_image,listitem_image)
VALUES (1,0,"DUMMY","","","","");

ALTER TABLE `renewenergy`.`productbase`
    ADD CONSTRAINT `fk_product_category` FOREIGN KEY (`cat_id`)
    REFERENCES `renewenergy`.`productbase` (`id`)
    ON UPDATE RESTRICT
    ON DELETE RESTRICT
;


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  PRODUCT BASE VIEWS
 *  ================================================================================================================== 
 *  ================================================================================================================== */
/*  ------------------------------------------------------------------------------
 *  VIEW:   CATEGORIES    
 *  NOTE:   ALL CATEGORIES BOTH ACTIVE & INACTIVE     
 *  ------------------------------------------------------------------------------ */
CREATE OR REPLACE VIEW `renewenergy`.`vw_categories` 
AS 
    SELECT  * 
    FROM    renewenergy.productbase
    WHERE   product_type = 1 
    WITH    LOCAL CHECK OPTION
;


/*  ------------------------------------------------------------------------------
 *  VIEW:   PRODUCTS    
 *  NOTE:   ALL PRODUCTS BOTH ACTIVE & INACTIVE
 *  ------------------------------------------------------------------------------ */
CREATE OR REPLACE VIEW `renewenergy`.`vw_products` 
AS 
    SELECT  * 
    FROM    renewenergy.productbase
    WHERE   product_type = 2 
    WITH    LOCAL CHECK OPTION
;


/*  ------------------------------------------------------------------------------
 *  VIEW:   SERVICES    
 *  NOTE:   ALL SERVICES BOTH ACTIVE & INACTIVE     
 *  ------------------------------------------------------------------------------ */
CREATE OR REPLACE VIEW `renewenergy`.`vw_services` 
AS 
    SELECT  * 
    FROM    renewenergy.productbase
    WHERE   product_type = 3 
    WITH    LOCAL CHECK OPTION
;


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  USERS
 *  ================================================================================================================== 
 *  ================================================================================================================== */
CREATE TABLE IF NOT EXISTS `renewenergy`.`users` (
    `id`                INT                 NOT NULL    AUTO_INCREMENT,
    `fname`             VARCHAR(30)         NOT NULL,
    `lname`             VARCHAR(30)         NOT NULL,
    `email`             VARCHAR(100)        NOT NULL,
    `password`          VARBINARY(50)       NOT NULL,
    `user_type`         TINYINT             NOT NULL    DEFAULT 2,  -- (1) admin, (2) member (3) visitor
    `address1`          VARCHAR(40)         NOT NULL,
    `address2`          VARCHAR(40)         NULL,
    `city`              VARCHAR(30)         NOT NULL,
    `county`            VARCHAR(30)         NOT NULL,
    `country`           VARCHAR(30)         NOT NULL,
    `postcode`          VARCHAR(10)         NULL,
    `last_updated`      TIMESTAMP           NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT `pk_user_id` PRIMARY KEY (`id`),
    CONSTRAINT `uq_user_email` UNIQUE KEY (`email`)
) 
ENGINE=InnoDB 
DEFAULT CHARSET=latin1 
AUTO_INCREMENT=1 
;



/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  ORDERS
 *  ================================================================================================================== 
 *  ================================================================================================================== */
CREATE TABLE IF NOT EXISTS `renewenergy`.`orders` (
    `order_no`              INT                 NOT NULL    AUTO_INCREMENT,
    `user_id`               INT                 NOT NULL,
    `status`                TINYINT             NOT NULL    DEFAULT 1, -- (1) On Order (2) Work In Progress (3) Ready (4) Shipped (5) Cancelled (6) Processed 
    `order_date`            DATETIME            NOT NULL,   -- NOW()
    `ship_date`             DATETIME            NULL,
    `last_updated`          TIMESTAMP           NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT `pk_order_number` PRIMARY KEY (`order_no`),
    CONSTRAINT `fk_user_order` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  ORDER TRIGGERS
 *  ================================================================================================================== 
 *  ================================================================================================================== */
/*  ------------------------------------------------------------------------------
 *  ACTION: AUTOMATICALLY SETS THE ORDER DATE TO THE CURRENT DATE ON INSERT 
 *  ------------------------------------------------------------------------------ */
CREATE TRIGGER `renewenergy`.`orders_order_date_trigger` 
BEFORE INSERT 
ON `renewenergy`.`orders`
FOR EACH ROW 
SET NEW.order_date = NOW()
;


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  ORDER ITEMS
 *  ================================================================================================================== 
 *  ================================================================================================================== */
CREATE TABLE IF NOT EXISTS `renewenergy`.`order_items` (
    `id`                INT                 NOT NULL	AUTO_INCREMENT,
    `order_no`          INT                 NOT NULL,
    `product_id`        INT                 NOT NULL,
    `quantity`          INT                 NOT NULL    DEFAULT 1,
    `price`             DECIMAL(8,2)        NOT NULL,
    CONSTRAINT `pk_item_id` PRIMARY KEY (`id`),
    CONSTRAINT `uq_order_product` UNIQUE KEY (`order_no`,`product_id`),
    CONSTRAINT `fk_order_item` FOREIGN KEY (`order_no`) REFERENCES `orders` (`order_no`),
    CONSTRAINT `fk_order_product` FOREIGN KEY (`product_id`) REFERENCES `productbase` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;


/***********************************************************************************************************************/
/***********************************************************************************************************************/
DELIMITER $$
/***********************************************************************************************************************/
/***********************************************************************************************************************/

/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  CATEGORY STORED PROCEDURES
 *  ================================================================================================================== 
 *  ================================================================================================================== */
/*----------------------------------------------------------------------------------------------------------
 * INSERT A CATEGORY  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_insert_category`$$

CREATE PROCEDURE `renewenergy`.`sp_insert_category`
(  
    IN      p_name              VARCHAR(40), 
    IN      p_introduction      VARCHAR(500),
    IN      p_overview          VARCHAR(2500),
    IN      p_overview_image    VARCHAR(60),
    IN      p_banner_image      VARCHAR(60),
    IN      p_listitem_image    VARCHAR(60),
    IN      p_how_image         VARCHAR(60),
    IN      p_brochure_file     VARCHAR(60),
    IN      p_faqs_file         VARCHAR(60),
    IN      p_video_url         VARCHAR(100),
    OUT     p_key               INT
)
BEGIN

    DECLARE ProductType, Category    TINYINT;

    SET ProductType = 1;    -- A product type for a category will always be 1.
    SET Category    = 1;    -- Categories will always refer to the 'Dummy' parent category, i.e. 1.

    INSERT INTO renewenergy.vw_categories 
            (name,introduction,overview,overview_image,banner_image,listitem_image,how_image,brochure_file,faqs_file,video_url,cat_id,product_type) 
    VALUES
            (p_name,p_introduction,p_overview,p_overview_image,p_banner_image,p_listitem_image,p_how_image,p_brochure_file,p_faqs_file,p_video_url,Category,ProductType);

    SET p_key = LAST_INSERT_ID();
END
$$


/*----------------------------------------------------------------------------------------------------------
 * UPDATE A CATEGORY  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_update_category`$$

CREATE PROCEDURE `renewenergy`.`sp_update_category`
(  
    IN      p_name              VARCHAR(40), 
    IN      p_introduction      VARCHAR(500),
    IN      p_overview          VARCHAR(2500),
    IN      p_overview_image    VARCHAR(60),
    IN      p_banner_image      VARCHAR(60),
    IN      p_listitem_image    VARCHAR(60),
    IN      p_how_image         VARCHAR(60),
    IN      p_brochure_file     VARCHAR(60),
    IN      p_faqs_file         VARCHAR(60),
    IN      p_video_url         VARCHAR(100),
    IN      p_id                INT,
    IN      p_last_updated      TIMESTAMP
)
BEGIN
    UPDATE      renewenergy.vw_categories 
    SET         name            = p_name, 
                introduction    = p_introduction, 
                overview        = p_overview, 
                overview_image  = p_overview_image, 
                banner_image    = p_banner_image, 
                listitem_image  = p_listitem_image,
                how_image       = p_how_image,
                brochure_file   = p_brochure_file, 
                faqs_file       = p_faqs_file,
                video_url       = p_video_url
    WHERE       id              = p_id 
    AND         last_updated    = p_last_updated;
END
$$ 


/*----------------------------------------------------------------------------------------------------------
 * DELETE A CATEGORY  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_delete_category`$$

CREATE PROCEDURE `renewenergy`.`sp_delete_category`
(
    IN  p_id  INT
)
BEGIN
    DELETE 
    FROM    renewenergy.vw_categories 
    WHERE   id = p_id;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * GET A CATEGORY BY KEY  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_category_by_key`$$

CREATE PROCEDURE `renewenergy`.`sp_get_category_by_key`(IN  p_key  INT)
BEGIN
    SELECT  * 
    FROM    renewenergy.vw_categories 
    WHERE   id = p_key 
    LIMIT   1;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * GET BASIC CATEGORIES DETAILS TO BE USED FOR COMBO BOX WHEN UPDATING A PRODUCT & PRODUCT SIDEBAR  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_basic_category_details`$$

CREATE PROCEDURE `renewenergy`.`sp_get_basic_category_details`()
BEGIN
    SELECT      id, 
                name
    FROM        renewenergy.vw_categories 
    ORDER BY    name;
END
$$


/*----------------------------------------------------------------------------------------------------------
 *  GET BRIEF CATEGORIES DETAILS TO BE USED IN ADMIN CATEGORIES LIST VIEW
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_brief_category_details`$$

CREATE PROCEDURE `renewenergy`.`sp_get_brief_category_details`()
BEGIN
    SELECT      id, 
                name, 
                introduction, 
                listitem_image, 
                last_updated
    FROM        renewenergy.vw_categories 
    ORDER BY    name;
END
$$


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  PRODUCT PROCEDURES
 *  ================================================================================================================== 
 *  ================================================================================================================== */
/*----------------------------------------------------------------------------------------------------------
 * INSERT A PRODUCT  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_insert_product`$$

CREATE PROCEDURE `renewenergy`.`sp_insert_product`
(   
    IN      p_cat_id            INT, 
    IN      p_name              VARCHAR(30), 
    IN      p_introduction      VARCHAR(500), 
    IN      p_overview          VARCHAR(2500), 
    IN      p_overview_image    VARCHAR(60),
    IN      p_banner_image      VARCHAR(60),
    IN      p_listitem_image    VARCHAR(60),
    IN      p_brochure_file     VARCHAR(60),
    IN      p_faqs_file         VARCHAR(60),
    IN      p_savings_Text      VARCHAR(150), 
    IN      p_savings_values    VARCHAR(50), 
    IN      p_price             DECIMAL(8,2), 
    IN      p_on_hand           INT,
    INOUT   p_key               INT
)
BEGIN

    DECLARE ProductType TINYINT;

    IF (fn_check_product_ranges(p_price,p_on_hand) > 0) THEN

        SET ProductType = 2;    -- A product type for a PRODUCT will always be 2.

        INSERT INTO renewenergy.vw_products 
            (cat_id,name,introduction,overview,savings_Text,savings_values,price,on_hand,banner_image,overview_image,listitem_image,brochure_file,faqs_file,product_type) 
        VALUES 
            (p_cat_id,p_name,p_introduction,p_overview,p_savings_Text,p_savings_values,p_price,p_on_hand,p_banner_image,p_overview_image,p_listitem_image,p_brochure_file,p_faqs_file,ProductType);
        
        SET p_key = LAST_INSERT_ID();

    END IF;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * UPDATE A PRODUCT  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_update_product`$$

CREATE PROCEDURE `renewenergy`.`sp_update_product`
(   
    IN      p_cat_id            INT,
    IN      p_name              VARCHAR(30), 
    IN      p_introduction      VARCHAR(500),
    IN      p_overview          VARCHAR(2500),
    IN      p_overview_image    VARCHAR(60),
    IN      p_banner_image      VARCHAR(60),
    IN      p_listitem_image    VARCHAR(60),
    IN      p_brochure_file     VARCHAR(60),
    IN      p_faqs_file         VARCHAR(60),
    IN      p_savings_Text      VARCHAR(150),
    IN      p_savings_values    VARCHAR(50),
    IN      p_price             DECIMAL(8,2),
    IN      p_on_hand           INT,
    IN      p_id                INT,
    IN      p_last_updated      TIMESTAMP
)
BEGIN

    IF (fn_check_product_ranges(p_price,p_on_hand) > 0) THEN

        UPDATE  renewenergy.vw_products 
        SET     cat_id          = p_cat_id, 
                name            = p_name, 
                introduction    = p_introduction, 
                overview        = p_overview, 
                overview_image  = p_overview_image, 
                banner_image    = p_banner_image, 
                listitem_image  = p_listitem_image,
                brochure_file   = p_brochure_file, 
                faqs_file       = p_faqs_file,
                savings_Text    = p_savings_Text, 
                savings_values  = p_savings_values, 
                price           = p_price, 
                on_hand         = p_on_hand
        WHERE   id              = p_id 
        AND     last_updated    = p_last_updated;

    END IF;

END
$$


/*----------------------------------------------------------------------------------------------------------
    PRODUCT PRICE AND ON-HAND CHECKS
    RETURNS 1 IF BOTH VALUES ARE WITHIN RANGE, ZERO OTHERWISE.
/*----------------------------------------------------------------------------------------------------------*/
DROP FUNCTION IF EXISTS `renewenergy`.`fn_check_product_ranges`$$

CREATE FUNCTION `renewenergy`.`fn_check_product_ranges`
(
    price       DECIMAL(8,2), 
    on_hand     INT
)
RETURNS TINYINT
BEGIN

    /* 
        IF NEITHER THE 'PRICE' OR THE 'ONHAND' VALUES MEET THEIR MINIMUM REQUIREMENTS,
        AN ERROR WILL BE THROWN THAT CAN BE CAUGHT BY OUR APPLICATION LAYER AS A 'SQLException'.
    */

    DECLARE rv TINYINT;
    DECLARE out_of_range_error CONDITION FOR SQLSTATE "45000";

    /* ASSUME THAT THIS IS GOING TO PASS !!! */
    SET rv = 1;

    IF (price NOT BETWEEN 1 AND 99999999.99) THEN
        SET rv = 0;
        SIGNAL out_of_range_error
        SET MESSAGE_TEXT = 'Price must be in the range of 1 to 99,999,999.99!!!', MYSQL_ERRNO = 1000;
    ELSEIF (on_hand NOT BETWEEN 0 AND 99999999) THEN
        SET rv = 0;
        SIGNAL out_of_range_error
        SET MESSAGE_TEXT = 'On hand Quantity must be in the range of 0 to 99,999,999!!!', MYSQL_ERRNO = 1001;
    END IF;

    RETURN rv;

END
$$


/*----------------------------------------------------------------------------------------------------------
 * DELETE A PRODUCT  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_delete_product`$$

CREATE PROCEDURE `renewenergy`.`sp_delete_product`
(
    IN  p_id    INT
)
BEGIN
    DELETE 
    FROM    renewenergy.vw_products 
    WHERE   id = p_id;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * GET A PRODUCT BY KEY
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_product_by_key`$$

CREATE PROCEDURE `renewenergy`.`sp_get_product_by_key`
(
    IN  p_id  INT
)
BEGIN
    SELECT  id, 
            cat_id, 
            name, 
            introduction, 
            overview, 
            banner_image,
            overview_image,
            listitem_image,
            brochure_file,
            faqs_file,
            savings_Text, 
            savings_values, 
            price, 
            on_hand, 
            last_updated
    FROM    renewenergy.vw_products
    WHERE   id = p_id 
    LIMIT   1;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * GET ALL PRODUCTS
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_all_products`$$

CREATE PROCEDURE `renewenergy`.`sp_get_all_products`()
BEGIN
    SELECT      renewenergy.vw_products.id, 
                renewenergy.vw_products.name, 
                renewenergy.vw_products.price, 
                renewenergy.vw_products.on_hand, 
                renewenergy.vw_products.last_updated, 
                renewenergy.vw_categories.name as category_name
    FROM        renewenergy.vw_products 
    JOIN        renewenergy.vw_categories
    ON          renewenergy.vw_products.cat_id = renewenergy.vw_categories.id
    ORDER BY    renewenergy.vw_products.name;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * GET BRIEF PRODUCT DETAILS BY CATEGORY KEY
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_brief_product_details_by_category_key`$$

CREATE PROCEDURE `renewenergy`.`sp_get_brief_product_details_by_category_key`
(
    IN  p_cat_id  INT
)
BEGIN
    SELECT      id, 
                cat_id, 
                name, 
                introduction, 
                price, 
                on_hand, 
                listitem_image 
    FROM        renewenergy.vw_products 
    WHERE       cat_id = p_cat_id
    ORDER BY    name;
END
$$

DELIMITER $$
/*----------------------------------------------------------------------------------------------------------
 * GET BASIC PRODUCT DETAILS BY CATEGORY KEY
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_basic_product_details_by_category_key`$$

CREATE PROCEDURE `renewenergy`.`sp_get_basic_product_details_by_category_key`
(
    IN  p_cat_id  INT
)
BEGIN
    SELECT      id, 
                name 
    FROM        renewenergy.vw_products 
    WHERE       cat_id = p_cat_id
    ORDER BY    name;
END
$$ 


/*----------------------------------------------------------------------------------------------------------
 * GET BRIEF PRODUCT DETAILS BY CATEGORY KEY
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_product_price_details_for_orders`$$

CREATE PROCEDURE `renewenergy`.`sp_get_product_price_details_for_orders`()
BEGIN
    SELECT      id, 
                name, 
                price, 
                on_hand
    FROM        renewenergy.productbase
    WHERE       product_type BETWEEN 2 AND 3
    ORDER BY    name;
END
$$ 


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  SERVICE PROCEDURES
 *  ================================================================================================================== 
 *  ================================================================================================================== */
/*----------------------------------------------------------------------------------------------------------
 * INSERT A SERVICE  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_insert_service`$$

CREATE PROCEDURE `renewenergy`.`sp_insert_service`
(   
    IN      p_name              VARCHAR(30), 
    IN      p_overview          VARCHAR(2500), 
    IN      p_overview_image    VARCHAR(60),
    IN      p_banner_image      VARCHAR(60),
    IN      p_listitem_image    VARCHAR(60),
    IN      p_price             DECIMAL(8,2), 
    IN      p_on_hand           INT,
    INOUT   p_key               INT
)
BEGIN

    DECLARE ProductType, Category   TINYINT;

    IF (fn_check_product_ranges(p_price,p_on_hand) > 0) THEN

        SET Category    = 1;    -- Services will always refer to the 'Dummy' parent category, i.e. 1.
        SET ProductType = 3;    -- A product type for a SERVICE will always be 3.

        INSERT INTO renewenergy.vw_services 
            (cat_id,name,overview,overview_image,banner_image,listitem_image,price,on_hand,product_type) 
        VALUES 
            (Category,p_name,p_overview,p_overview_image,p_banner_image,p_listitem_image,p_price,p_on_hand,ProductType);
        
        SET p_key = LAST_INSERT_ID();

    END IF;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * INSERT A SERVICE  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_update_service`$$

CREATE PROCEDURE `renewenergy`.`sp_update_service`
(   
    IN      p_name              VARCHAR(30), 
    IN      p_overview          VARCHAR(2500), 
    IN      p_overview_image    VARCHAR(60),
    IN      p_banner_image      VARCHAR(60),
    IN      p_listitem_image    VARCHAR(60),
    IN      p_price             DECIMAL(8,2), 
    IN      p_on_hand           INT,
    IN      p_key               INT,
    IN      p_last_updated      TIMESTAMP
)
BEGIN

    UPDATE  renewenergy.vw_services 
    SET     name            = p_name, 
            overview        = p_overview, 
            overview_image  = p_overview_image, 
            banner_image    = p_banner_image, 
            listitem_image  = p_listitem_image,
            price           = p_price,
            on_hand         = p_on_hand
    WHERE   id              = p_key 
    AND     last_updated    = p_last_updated;

END
$$


/*----------------------------------------------------------------------------------------------------------
 * DELETE A SERVICE  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_delete_service`$$

CREATE PROCEDURE `renewenergy`.`sp_delete_service`
(
    IN p_key INT
)
BEGIN
    DELETE FROM renewenergy.vw_services 
    WHERE id = p_key;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * GET ALL SERVICES
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_all_services`$$

CREATE PROCEDURE `renewenergy`.`sp_get_all_services`()
BEGIN
    SELECT  id,
            name, 
            overview, 
            overview_image,
            banner_image,
            listitem_image,
            price, 
            on_hand, 
            last_updated
    FROM    renewenergy.vw_services;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * GET A SERVICE BY KEY
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_service_by_key`$$

CREATE PROCEDURE `renewenergy`.`sp_get_service_by_key`
(
    IN  p_id  INT
)
BEGIN
    SELECT  id,
            name, 
            overview, 
            overview_image,
            banner_image,
            listitem_image,
            price, 
            on_hand, 
            last_updated
    FROM    renewenergy.vw_services
    WHERE   id = p_id 
    LIMIT   1;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * GET BRIEF DETAILS FOR ALL SERVICES
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_brief_service_details`$$

CREATE PROCEDURE `renewenergy`.`sp_get_brief_service_details`()
BEGIN
    SELECT  id,
            name,
            listitem_image
    FROM    renewenergy.vw_services 
    ORDER BY vw_services.name;
END
$$


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  USERS PROCEDURES
 *  ================================================================================================================== 
 *  ================================================================================================================== */
/*----------------------------------------------------------------------------------------------------------
/* INSERT A USER 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_insert_user`$$
CREATE PROCEDURE `renewenergy`.`sp_insert_user`
( 
    IN      p_fname         VARCHAR(30),
    IN      p_lname         VARCHAR(30),
    IN      p_address1      VARCHAR(40),
    IN      p_address2      VARCHAR(40),
    IN      p_city          VARCHAR(30),
    IN      p_county        VARCHAR(30),
    IN      p_country       VARCHAR(30),
    IN      p_postcode      VARCHAR(10),
    IN      p_email         VARCHAR(100),
    IN      p_password      VARCHAR(10),
    IN      p_user_type     TINYINT,
    INOUT   p_key           INT
)
BEGIN
    INSERT INTO users (fname,lname,address1,address2,city,county,country,postcode,email,password,user_type) 
    VALUES (p_fname,
            p_lname,
            p_address1,
            p_address2,
            p_city,
            p_county,
            p_country,
            p_postcode,
            p_email,
            fn_encrypt_password(p_password),
            p_user_type);

    SET p_key = LAST_INSERT_ID();
END
$$

/*----------------------------------------------------------------------------------------------------------
/* UPDATE A USER 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_update_user`$$
CREATE PROCEDURE `renewenergy`.`sp_update_user`
( 
    IN      p_fname         VARCHAR(30),
    IN      p_lname         VARCHAR(30),
    IN      p_address1      VARCHAR(40),
    IN      p_address2      VARCHAR(40),
    IN      p_city          VARCHAR(30),
    IN      p_county        VARCHAR(30),
    IN      p_country       VARCHAR(30),
    IN      p_postcode      VARCHAR(10),
    IN      p_email         VARCHAR(100),
    IN      p_password      VARCHAR(10),
    IN      p_user_type     TINYINT,
    IN      p_last_updated  TIMESTAMP,
    IN      p_id            INT
)
BEGIN
    UPDATE  users 
    SET     fname       = p_fname, 
            lname       = p_lname, 
            address1    = p_address1, 
            address2    = p_address2, city = p_city, 
            county      = p_county, 
            country     = p_country, 
            postcode    = p_postcode, 
            email       = p_email, 
            password    = fn_encrypt_password(p_password), 
            user_type   = p_user_type
    WHERE   id          = p_id 
    AND     last_updated = p_last_updated;
END
$$


/*----------------------------------------------------------------------------------------------------------
/* DELETE A USER 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_delete_user`$$
CREATE PROCEDURE `renewenergy`.`sp_delete_user`
(
    IN  p_id    INT
)
BEGIN
    DELETE FROM users 
    WHERE id = p_id;
END
$$


/*----------------------------------------------------------------------------------------------------------*/
/* GET ALL USERS                                                                                            */
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_all_users`$$
CREATE PROCEDURE `renewenergy`.`sp_get_all_users`()
BEGIN
    SELECT id,fname,lname,email,user_type
    FROM users 
    ORDER BY users.lname, users.fname;
END
$$


/*----------------------------------------------------------------------------------------------------------*/
/* GET USER BY ID                                                                                           */
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_user_by_id`$$
CREATE PROCEDURE `renewenergy`.`sp_get_user_by_id`
(
    IN  p_id    INT
)
BEGIN    
    SELECT  id,
            fname,
            lname,
            email,
            user_type,
            address1,
            address2,
            city,
            county,
            country,
            postcode,
            last_updated, 
            fn_decrypt_password(password) password
    FROM    users
    WHERE   id = p_id
    LIMIT 1;
END
$$


/*----------------------------------------------------------------------------------------------------------*/
/* GET USER BY ID FOR AN ORDER                                                                              */
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_user_for_order`$$
CREATE PROCEDURE `renewenergy`.`sp_get_user_for_order`
(
    IN      p_id    INT
)
BEGIN    
    SELECT id,fname,lname,email,user_type,address1,address2,city,county,country,postcode
    FROM users
    WHERE id = p_id
    LIMIT 1;
END
$$


/*----------------------------------------------------------------------------------------------------------*/
/* GET USER LOGIN                                                                                           */
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_user_login`$$
CREATE PROCEDURE `renewenergy`.`sp_get_user_login`
(  
    IN  p_email     VARCHAR(100),
    IN  p_password  VARCHAR(10)
)
BEGIN    
    SELECT  id,
            fname,
            lname,
            email,
            user_type,
            address1,
            address2,
            city,
            county,
            country,
            postcode,
            last_updated, 
            fn_decrypt_password(password) password
    FROM    users
    WHERE   email = p_email 
    AND     password = fn_encrypt_password(p_password)
    LIMIT   1;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * ENCRYPT PASSWORD
/*----------------------------------------------------------------------------------------------------------*/
DROP FUNCTION IF EXISTS `renewenergy`.`fn_encrypt_password`$$

CREATE FUNCTION `renewenergy`.`fn_encrypt_password`
(
     p_password          VARCHAR(10)
)
RETURNS VARBINARY(50)
BEGIN
    DECLARE encrypted_pwd VARBINARY(50);

    SET  encrypted_pwd = AES_ENCRYPT(p_password,'kietdf4ksa');

    RETURN encrypted_pwd;
END
$$


/*----------------------------------------------------------------------------------------------------------
 * DECRYPT PASSWORD
/*----------------------------------------------------------------------------------------------------------*/
DROP FUNCTION IF EXISTS `renewenergy`.`fn_decrypt_password`$$

CREATE FUNCTION `renewenergy`.`fn_decrypt_password`
(
     p_password          VARBINARY(50)
)
RETURNS VARCHAR(10)
BEGIN
    DECLARE decrypted_pwd VARCHAR(10);

    SET  decrypted_pwd = AES_DECRYPT(p_password,'kietdf4ksa');

    RETURN decrypted_pwd;
END
$$

/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  ORDER PROCEDURES
 *  ================================================================================================================== 
 *  ================================================================================================================== */
/*----------------------------------------------------------------------------------------------------------
    INSERT ORDER 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_insert_order`$$
CREATE PROCEDURE `renewenergy`.`sp_insert_order`
(
    IN      p_user_id   INT,
    INOUT   p_order_no  INT
)
BEGIN
    INSERT INTO `renewenergy`.`orders` (user_id) 
    VALUES (p_user_id);
    SET p_order_no = LAST_INSERT_ID();
END
$$


/*----------------------------------------------------------------------------------------------------------
    UPDATE ORDER 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_update_order`$$
CREATE PROCEDURE `renewenergy`.`sp_update_order`
(
    IN  p_user_id       INT,
    IN  p_status        TINYINT,
    IN  p_order_no      INT,
    IN  p_ship_date     DATETIME,
    IN  p_last_updated  TIMESTAMP
)
BEGIN
    UPDATE  `renewenergy`.`orders` 
    SET     user_id         = p_user_id,
            status          = p_status,
            ship_date       = p_ship_date
    WHERE   order_no        = p_order_no
    AND     last_updated    = p_last_updated;
END
$$


/*----------------------------------------------------------------------------------------------------------
    DELETE ORDER 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_delete_order`$$
CREATE PROCEDURE `renewenergy`.`sp_delete_order`
(
    IN      p_order_no  INT
)
BEGIN
    DELETE FROM `renewenergy`.`orders`
    WHERE order_no = p_order_no;
END
$$


/*----------------------------------------------------------------------------------------------------------
    GET ALL ORDERS 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_all_orders`$$
CREATE PROCEDURE `renewenergy`.`sp_get_all_orders`()
    SELECT  orders.order_no,
            orders.user_id,
            orders.status,
            orders.order_date,
            orders.ship_date,
            orders.last_updated,
            users.fname,
            users.lname,
            users.email,
            users.address1,
            users.address2,
            users.city,
            users.county,
            users.country,
            users.postcode
    FROM    `renewenergy`.`orders` 
    JOIN    `renewenergy`.`users`
    ON      orders.user_id = users.id
    ORDER BY orders.order_no
$$

/*----------------------------------------------------------------------------------------------------------
    GET ORDER BY ID  
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_order_by_id`$$
CREATE PROCEDURE `renewenergy`.`sp_get_order_by_id`
(
    IN      p_order_no      INT
)
BEGIN
    SELECT  orders.order_no,
            orders.user_id,
            orders.status,
            orders.order_date,
            orders.ship_date,
            orders.last_updated,
            users.fname,
            users.lname,
            users.email,
            users.address1,
            users.address2,
            users.city,
            users.county,
            users.country,
            users.postcode
    FROM    `renewenergy`.`orders` 
    JOIN    `renewenergy`.`users`
    ON      orders.user_id = users.id
    WHERE   orders.order_no = p_order_no
    LIMIT 1;
END
$$


/*----------------------------------------------------------------------------------------------------------
    GET ORDERS BY USER ID 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_orders_by_user_id`$$
CREATE PROCEDURE `renewenergy`.`sp_get_orders_by_user_id`
(
    IN      p_user_id       INT
)
BEGIN
    SELECT  orders.order_no,
            orders.user_id,
            orders.status,
            orders.order_date,
            orders.ship_date,
            orders.last_updated,
            users.fname,
            users.lname,
            users.email,
            users.address1,
            users.address2,
            users.city,
            users.county,
            users.country,
            users.postcode,
            SUM(order_items.quantity * order_items.price) total_price
    FROM    order_items
    JOIN    `renewenergy`.`orders`
    ON      order_items.order_no = orders.order_no
    JOIN    `renewenergy`.`users`
    ON      orders.user_id = users.id
    WHERE   orders.user_id = p_user_id
    GROUP BY order_items.order_no;
END
$$


/* ----------------------------------------------------------------------------------------------------------------- */
/* ------------------------------------------ ORDER ITEM STORED PROCEDURES ----------------------------------------- */
/* ----------------------------------------------------------------------------------------------------------------- */

/*----------------------------------------------------------------------------------------------------------
    INSERT ORDER ITEM 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_insert_order_item`$$
CREATE PROCEDURE `renewenergy`.`sp_insert_order_item`
(   
    IN      p_order_no      INT,
    IN      p_product_id    INT,
    IN      p_quantity      INT,
    IN      p_price         DECIMAL(8,2),
    INOUT   p_item_id       INT
)
BEGIN

    IF (fn_check_product_ranges(p_price,p_quantity) > 0) THEN

        INSERT INTO order_items (order_no,product_id,quantity,price) 
        VALUES (p_order_no,p_product_id,p_quantity,p_price);
        SET p_item_id = LAST_INSERT_ID();

    ELSE

        SET p_item_id = -1;

    END IF;
    
END
$$


/*----------------------------------------------------------------------------------------------------------
    UPDATE ORDER ITEM 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_update_order_item`$$
CREATE PROCEDURE `renewenergy`.`sp_update_order_item`
(
    IN  p_quantity      INT,
    IN  p_price         DECIMAL(8,2),
    IN  p_id            INT
)
BEGIN

    IF (fn_check_product_ranges(p_price,p_quantity) > 0) THEN

        UPDATE  order_items 
        SET     quantity    = p_quantity,
                price       = p_price
        WHERE   id          = p_id;

    END IF;

END
$$

/*----------------------------------------------------------------------------------------------------------
    DELETE ORDER ITEM 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_delete_order_item`$$
CREATE PROCEDURE `renewenergy`.`sp_delete_order_item`
(
    IN      p_id    INT
)
BEGIN

    DELETE FROM order_items 
    WHERE id = p_id;

END
$$

/*----------------------------------------------------------------------------------------------------------
    GET ALL ORDER ITEMS 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_all_get_order_items`$$
CREATE PROCEDURE `renewenergy`.`sp_all_get_order_items`()
BEGIN

    SELECT  order_items.id,
            order_items.order_no,
            order_items.product_id,
            order_items.quantity,
            order_items.price,
            productbase.name,
            productbase.price product_price,
            productbase.on_hand
    FROM    order_items
    JOIN    productbase
    ON      order_items.product_id = productbase.id
    ORDER BY order_items.id, productbase.name;

END
$$

/*----------------------------------------------------------------------------------------------------------
    GET ORDER ITEMS FOR ORDER 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_order_items`$$
CREATE PROCEDURE `renewenergy`.`sp_get_order_items`
(
    IN      p_order_no   INT
)
BEGIN
    SELECT  order_items.id,
            order_items.order_no,
            order_items.product_id,
            order_items.quantity,
            order_items.price,
            productbase.name,
            productbase.price product_price,
            productbase.on_hand
    FROM    order_items
    JOIN    productbase
    ON      order_items.product_id = productbase.id
    WHERE   order_items.order_no = p_order_no
    ORDER BY productbase.name;
END
$$

/*----------------------------------------------------------------------------------------------------------
    GET ORDER ITEM BY ID
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_order_item_by_id`$$
CREATE PROCEDURE `renewenergy`.`sp_get_order_item_by_id`
(
    IN      p_id    INT
)
BEGIN
    SELECT  order_items.id,
            order_items.order_no,
            order_items.product_id,
            order_items.quantity,
            order_items.price,
            productbase.name,
            productbase.price product_price,
            productbase.on_hand
    FROM    order_items
    JOIN    productbase
    ON      order_items.product_id = productbase.id
    WHERE   order_items.id = p_id
    LIMIT 1;
END
$$

/*----------------------------------------------------------------------------------------------------------
    GET ORDER ITEM BY PRODUCT ID & ORDER NO. 
/*----------------------------------------------------------------------------------------------------------*/
DROP PROCEDURE IF EXISTS `renewenergy`.`sp_get_order_item_by_order_product`$$
CREATE PROCEDURE `renewenergy`.`sp_get_order_item_by_order_product`
( 
    IN  p_order_no      INT,
    IN  p_product_id    INT
)
BEGIN
    SELECT * FROM order_items
    WHERE   order_no    = p_order_no
    AND     product_id  = p_product_id
    LIMIT 1;
END
$$


/***********************************************************************************************************************/
/***********************************************************************************************************************/
DELIMITER ;
/***********************************************************************************************************************/
/***********************************************************************************************************************/


/*  ==================================================================================================================
 *  ================================================================================================================== 
 *  DATA
 *  ================================================================================================================== 
 *  ================================================================================================================== */

/*----------------------------------------------------------------------------------------------------------
 * CATEGORY DATA
/*----------------------------------------------------------------------------------------------------------*/
CALL sp_insert_category(
    "Solar Panels",
    "Solar panels are the most common and affordable form of alternative energy available in Ireland.<strong>Renew Total Energy Solutions can provide a suitably sized solar panel system for your new or existing home, Agricultural out-house or business premise. </strong><br/>We can supply and install systems to any location in Ireland.",
    "So your interested in saving money, doing your bit for the planet and increasing your <a  href='http://www.seai.ie/Your_Building/BER/BER_Assessors/Administration_for_BER_Assessors/Marketing_Guidelines_for_BER_Assessors/' target='_blank'>Building Energy Rating (BER).</a><br/><br/>Solar has a fast payback period, is free of running costs and will greatly increase your BER. Some people think the only benefit from solar is direct financial saving from the fuel saved. <br/><br/>Don't forget that solar will greatly increase your BER. This in turn, will help maintain a high re-sale value for your home, when compared to a similar property. Finances aside; it will reduce the carbon emissions from your home. This is very important as the new carbon taxes in 2009 are going to effect us all financially.<br/><br/><strong><em>...There are many ways to generate energy. And one way to do so is by harnessing what is naturally there. Why spend a fortune on electrical bills when we can use solar panels at home and save a lot of money? In the end, it is not only about being frugal, it is also about helping our environment.</em></strong>",
    "solarpanels_overviewimage.jpg",
    "solarpanels_bannerimage.jpg",
    "solarpanels_listimage.jpg",
    "solarpanels_howitworksimage.jpg",
    "solarpanels_brochure.pdf",
    "solarpanels_faqs.pdf",
    "http://www.youtube.com/embed/GmB45pclqPo",
    @A
);

CALL sp_insert_category(
    "Solar Slates",
    "A Solar Slate is an efficient <strong>roof-integrated</strong> photovoltaic slate, the long awaited green solution to planning constraints for conservation areas and historic buildings wanting to improve their carbon footprint. Our innovative solar slates combine the <strong>latest in photovoltaic technology</strong> with similar <strong>aesthetic properties</strong> to roofing slates.",
    "A Solar Slate is an efficient roof-integrated photovoltaic slate, the long-awaited green solution to planning constraints for conservation areas and historic buildings wanting to improve their carbon footprint. Our innovative Solar Slates combine the latest in photovoltaic technology with similar aesthetic properties to roofing slates.<br/><br/>They are fully weather proof and, unlike usual solar panels, blend in with standard roof slates to provide an aesthetically pleasing solar panel roof. Solar Slate is ideal for use in conservation areas, on historic buildings, new builds or renovation projects.<br/><br/>This micro-generation energy source helps to meet legislative targets. Whether you have to use on-site renewables to meet a planning requirement, or you simply want to improve your carbon footprint, Solar Slate now enables you to do this with a traditional slate roof.<br/><br/><strong>The guarantee terms include a 10 year product and roof integrity guarantee and 10 year minimum performance guarantee.</strong>",
    "solarslates_overviewimage.jpg",
    "solarslates_bannerimage.jpg",
    "solarslates_listimage.jpg",
    "solarslates_howitworksimage.jpg",
    "solarslates_brochure.pdf",
    "solarslates_faqs.pdf",
    "http://www.youtube.com/embed/bjPNt7D84HA",
    @A
);

CALL sp_insert_category(
    "Wind Turbines",
    "Households and Businesses that choose a professional wind energy company like <strong>Renew</strong> to manage their wind energy project can save a great deal of money and time. It takes considerable expertise to plan, install and commission an efficient wind energy solution. We use tried and tested Proven wind turbines for <strong>maximum efficiency</strong>.",
    "<strong>Households and Businesses</strong> that choose a professional wind energy company to manage their wind energy project can save a great deal of money and time. It takes considerable expertise to plan, install and commission an efficient wind energy solution. We use tried and tested <strong>Proven Wind Turbines</strong> for maximum efficiency.<br/><br/><strong>Proven</strong> are a range from Scotland where the Weather is similar to that of Ireland. These units have a long track record for reliability and resilience.<br/><br/>Wind energy systems are one of the most cost effective, reliable and efficient renewable energy sources available. Ireland has the highest potential in Europe for producing wind energy yet every year we spend 6 billion abroad on fossil fuels to provide electricity to our homes and businesses.<br/><br/><strong>With rising energy costs and a growing commitment to green living, progressive home owners are harnessing the power of the wind to generate their own electricity. Wind energy is one of the most efficient and reliable forms of renewable energy available.</strong>",
    "windturbines_overviewimage.jpg",
    "windturbines_bannerimage.jpg",
    "windturbines_listimage.jpg",
    "windturbines_howitworksimage.jpg",
    "windturbines_brochure.pdf",
    "windturbines_faqs.pdf",
    "http://www.youtube.com/embed/V5jupBwAhXI",
    @A
);


/*----------------------------------------------------------------------------------------------------------*/
/* INSERT PRODUCT DATA                                                                                      */
/*----------------------------------------------------------------------------------------------------------*/
CALL sp_insert_product(
    2,
    "Thermodynamic Solar Collector",
    "<strong>Thermodynamic</strong> systems use a different method for generating hot water compared to the conventional solar panels. <strong>One panel</strong> can provide hot water for a family of 6 per day &#45; all year round ! Our system uses a single panel mounted on your roof, wall or the ground and is piped back to the thermodynamic cylinder.<br/><br/><strong>Thermodynamic Panels will provide you with approximately 100&#37; of your annual hot water needs</strong>.",
    "<strong>Renew Energy Thermodynamic Solar Collectors</strong> consist of anodised aluminium, powder coated to a black finish so they are aesthetically pleasing and non invasive. <br/><br/><strong>These collectors are the most cost effective</strong> and provide a great return on investment. A 6m&#178; Thermodynamic Solar Water Heater installations in Ireland could possibly provide the energy equivalent of a 3KW immersion heater running for almost 8 hours on average, every day, 365 days per year.<br/><br/>If you are thinking of installing a Solar panel system there is no better time than now.  The goverment have launched a new scheme called the <strong>'Better Energy Programme'</strong>. You can currently avail of an SEAI grant of <strong>€800</strong> euro for installing a <br/>Solar Heating system.",
    "thermodynamicsolarcollector_overviewimage.jpg",
    "thermodynamicsolarcollector_bannerimage.jpg",
    "thermodynamicsolarcollector_listimage.jpg",
    "solarpanels_brochure.pdf",
    "solarpanels_faqs.pdf",
    "<strong>Thermodynamic Panels will provide you with approximately 100&#37; of your annual hot water needs</strong>.",
    "100,100,100,100,100,100,100,100,100,100,100,100",  
    5500,
    20,
    @A
);


CALL sp_insert_product(
    2,
    "Flat Panel Solar Collector",
    "Flat panel solar collectors are highly cost effective and provide a great return on investment. A 6m&#178; Flat Plate Solar Water Heater installations in Ireland could possibly provide the energy equivalent of a 3KW immersion heater running for almost 5 hours on average, every day, 365 days per year.<br/><br/><strong>Flat plate panels will provide you with approximately 70% of your annual hot water needs</strong>.",
    "<strong>Renew Energy Flat Panel Solar Collectors</strong> solar panels have structured (clouded) glass surrounded in a Dark Brown frame.<br/><br/>When we picture solar PV panels, we often think of the <em>'traditional'</em> thick aluminium framed panels that might not be a fit for every home.<br/><br/>Fortunately, there are now far more types of panels available, including slate coloured tiles which seamlessly integrate into the roof. <br/><br/>The Clouded glass means that the panels look attractive as none of the internal workings are visible but efficiency is not compromised.",
    "flatpanelsolarcollector_overviewimage.jpg",
    "flatpanelsolarcollector_bannerimage.jpg",
    "flatpanelsolarcollector_listimage.jpg",
    "solarpanels_brochure.pdf",
    "solarpanels_faqs.pdf",
    "<strong>Flat plate panels will provide you with approximately 70% of your annual hot water needs</strong>.",
    "50,70,75,80,90,100,100,90,90,75,70,50",    
    4750,
    15,
    @A
);

CALL sp_insert_product(
    2,
    "Evacuated Tube Collector",
    "Evacuated tube collectors are highly cost effective and provide a great return on investment. A 6m&#178; Evacuated Tube Solar Water Heater installations in Ireland could possibly provide the energy equivalent of a 3KW immersion heater running for almost 2 hours on average, every day, 365 days per year.<br/><br/><strong>Evacuated Tube panels will provide you with approximately 50% of your annual hot water needs</strong>.",
    "<strong>Renew Energy Solar Tubes Collectors</strong> feature an attractive Dark Brown body and also a dark coloured Curved manifold on top. These are widely recognised as the most attractive vacuum tube solar panels available in Ireland.<br/><br/>Evacuated Tubes feature a Compound Parabolic Concentrator (CPC) which is basically a <em>'curved mirror'</em> underneath each individual tube.<br/><br/>This ensures that ALL light is reflected onto the collector ensuring high efficiency. <strong>CPC tubes are up to 40% more efficient than Non-CPC tubes.</strong><br/><br/>You can currently avail of an SEAI grant of <strong>€800</strong> euro for installing a Solar Heating system.",
    "evacuatedtubecollector_overviewimage.jpg",
    "evacuatedtubecollector_bannerimage.jpg",
    "evacuatedtubecollector_listimage.jpg",
    "solarpanels_brochure.pdf",
    "solarpanels_faqs.pdf",
    "<strong>Evacuated Tube collectors will provide you with approximately 50% of your annual hot water needs</strong>.",
    "10,20,30,40,60,80,70,60,40,30,20,10",   
    3000,
    30,
    @A
);


CALL sp_insert_product(
    3,
    "Photovoltaic Solar Slate C21",
    "Solar Slate is an efficient roof-integrated photovoltaic slate, the long-awaited green solution to planning constraints for conservation areas and historic buildings wanting to improve their carbon footprint. A 30 slate installation in Ireland could possibly provide the energy equivalent of a 3KW immersion heater running for almost 5 hours on average, every day, 365 days per year.<br/><br/><strong>Solar Slate Panels will provide you with approximately 80% of your annual hot water needs</strong>.",
    "<strong>Renew Energy Solar Slate Collectors</strong> come in 3 styles <strong>(C21, C22, C23)</strong> and are aesthetically pleasing and non invasive and combine the latest in photovoltaic technology with similar aesthetic properties to roofing slates.<br/><br/>They are fully weather proof and, unlike usual solar panels, blend in with standard roof slates to provide an aesthetically pleasing solar panel roof.<br/><br/><strong>Solar Slate is ideal for use in conservation areas, on historic buildings, new builds or renovation projects.</strong><br/><br/>You can currently avail of an SEAI grant of <strong>€800</strong> euro for installing a Solar Heating system.",
    "photovoltaicsolarslatec21_overviewimage.jpg",
    "photovoltaicsolarslatec21_bannerimage.jpg",
    "photovoltaicsolarslatec21_listimage.jpg",
    "solarslates_brochure.pdf",
    "solarslates_faqs.pdf",
    "<strong>Solar slate panels will provide you with approximately 80% of your annual hot water needs</strong>.",
    "85,85,85,90,100,100,100,90,90,85,85,85",    
    60,
    3000,
    @A
);

CALL sp_insert_product(
    3,
    "Photovoltaic Solar Slate C22",
    "Solar Slate is an efficient roof-integrated photovoltaic slate, the long-awaited green solution to planning constraints for conservation areas and historic buildings wanting to improve their carbon footprint. A 30 slate installation in Ireland could possibly provide the energy equivalent of a 3KW immersion heater running for almost 5 hours on average, every day, 365 days per year.<br/><br/><strong>Solar Slate Panels will provide you with approximately 80% of your annual hot water needs</strong>.",
    "<strong>Renew Energy Solar Slate Collectors</strong> come in 3 styles <strong>(C21, C22, C23)</strong> and are aesthetically pleasing and non invasive and combine the latest in photovoltaic technology with similar aesthetic properties to roofing slates.<br/><br/>They are fully weather proof and, unlike usual solar panels, blend in with standard roof slates to provide an aesthetically pleasing solar panel roof.<br/><br/><strong>Solar Slate is ideal for use in conservation areas, on historic buildings, new builds or renovation projects.</strong><br/><br/>You can currently avail of an SEAI grant of <strong>€800</strong> euro for installing a Solar Heating system.",
    "photovoltaicsolarslatec22_overviewimage.jpg",
    "photovoltaicsolarslatec22_bannerimage.jpg",
    "photovoltaicsolarslatec22_listimage.jpg",
    "solarslates_brochure.pdf",
    "solarslates_faqs.pdf",
    "<strong>Solar slate panels will provide you with approximately 80% of your annual hot water needs</strong>.",
    "85,85,85,90,100,100,100,90,90,85,85,85",    
    65,
    2800,
    @A
);

CALL sp_insert_product(
    3,
    "Photovoltaic Solar Slate C23",
    "Solar Slate is an efficient roof-integrated photovoltaic slate, the long-awaited green solution to planning constraints for conservation areas and historic buildings wanting to improve their carbon footprint. A 30 slate installation in Ireland could possibly provide the energy equivalent of a 3KW immersion heater running for almost 5 hours on average, every day, 365 days per year.<br/><br/><strong>Solar Slate Panels will provide you with approximately 80% of your annual hot water needs</strong>.",
    "<strong>Renew Energy Solar Slate Collectors</strong> come in 3 styles <strong>(C21, C22, C23)</strong> and are aesthetically pleasing and non invasive and combine the latest in photovoltaic technology with similar aesthetic properties to roofing slates.<br/><br/>They are fully weather proof and, unlike usual solar panels, blend in with standard roof slates to provide an aesthetically pleasing solar panel roof.<br/><br/><strong>Solar Slate is ideal for use in conservation areas, on historic buildings, new builds or renovation projects.</strong><br/><br/>You can currently avail of an SEAI grant of <strong>€800</strong> euro for installing a Solar Heating system.",
    "photovoltaicsolarslatec23_overviewimage.jpg",
    "photovoltaicsolarslatec23_bannerimage.jpg",
    "photovoltaicsolarslatec23_listimage.jpg",
    "solarslates_brochure.pdf",
    "solarslates_faqs.pdf",
    "<strong>Solar slate panels will provide you with approximately 80% of your annual hot water needs</strong>.",
    "85,85,85,90,100,100,100,90,90,85,85,85",    
    70,
    3050,
    @A
);


CALL sp_insert_product(
    4,
    "Provin 3Kw Wind Turbine",
    "<strong>Suitability: Off-grid Applications, Telecoms</strong><br/><br/>The <strong>KW3</strong> wind turbine stands out from all other small scale wind turbines due to its unique blade and hinge design which allows it to regulate its rotational speed, maximising output - as the wind gets stronger the blades pitch and cone, protecting the turbine and allowing continual operation during the fiercest of storms.",
    "The <strong>KW3</strong>  wind turbine is the result of over 30 years research and development and born from a global installed fleet size in excess of 800 � including the world's largest rural off-grid fleet in The Falkland Islands through to specialist installations in Asia, Europe, North America, offshore oil platforms and the global telecoms sector.<br/><br/>Designed to operate in any wind regime � high performance is maintained even in the fiercest storms. Our unique over-speed protection system, coupled with our delta rotor design ensures continuous energy generation.<br/><br/>Our turbines are well suited to rural domestic, farming and agricultural applications and are available with a variety of tower heights; 9m, 11.6 or 15m towers ",
    "provin3kwwindturbine_overviewimage.jpg",
    "provin3kwwindturbine_bannerimage.jpg",
    "provin3kwwindturbine_listimage.jpg",
    "windturbines_brochure.pdf",
    "windturbines_faqs.pdf",
    "<strong>The Provin 3Kw Wind Turbine will provide you with approximately 60% of your annual electricty needs</strong>.",
    "60,70,70,70,50,50,60,70,80,90,90,70",    
    6000,
    5,
    @A
);

CALL sp_insert_product(
    4,
    "Provin 6Kw Wind Turbine",
    "<strong>Suitability: Rural-domestic, Agricultural, Small-holdings, Commercial</strong><br/><br/>The <strong>KW6</strong> wind turbine stands out from all other small scale wind turbines due to its unique blade and hinge design which allows it to regulate its rotational speed, maximising output - as the wind gets stronger the blades pitch and cone, protecting the turbine and allowing continual operation during the fiercest of storms.",
    "The <strong>KW6</strong> wind turbine is the result of over 30 years research and development and born from a global installed fleet size in excess of 4000 turbines.<br/>Installed in over 60 countries and in every continent.<br/><br/>Designed to operate in any wind regime � high performance is maintained even in the fiercest storms. Our unique over-speed protection system, coupled with our delta rotor design ensures continuous energy generation.<br/><br/>Our turbines are well suited to rural domestic, farming and agricultural applications and are available with a variety of tower heights; 9m, 11.6 or 15m towers ",
    "provin6kwwindturbine_overviewimage.jpg",
    "provin6kwwindturbine_bannerimage.jpg",
    "provin6kwwindturbine_listimage.jpg",
    "windturbines_brochure.pdf",
    "windturbines_faqs.pdf",
    "<strong>The Provin 6Kw Wind Turbine will provide you with approximately 70% of your annual electricty needs</strong>.",
    "60,60,60,80,50,60,70,80,80,80,80,80",    
    8500,
    3,
    @A
);

CALL sp_insert_product(
    4,
    "Provin 15Kw Wind Turbine",
    "<strong>Suitability: Large Agricultural & Commercial Dwellings</strong><br/><br/>The <strong>KW15</strong> wind turbine has been designed and rigorously tested to ensure simple, affordable and responsible energy generation for land owners, farmers, developers and community projects all over the world.<br/><br/>The turbine has been designed to perform in all wind speeds, offering owners a faster payback and greater return on investment compared to similarly rated wind turbines.",
    "The <strong>KW15</strong> incorporates four levels of rotor speed control to ensure that the turbine operates responsibly in all wind conditions - the advanced inverter constantly monitors the voltage and RPM of the turbine.<br/><br/>Dynamic loading allows the KW15 to maintain its most efficient RPM in any wind regime. No requirement is needed to shut down in high winds.<br/><br/>Designed to operate in any wind regime � high performance is maintained even in the fiercest storms. Our unique over-speed protection system, coupled with our delta rotor design ensures continuous energy generation.",
    "provin15kwwindturbine_overviewimage.jpg",
    "provin15kwwindturbine_bannerimage.jpg",
    "provin15kwwindturbine_listimage.jpg",
    "windturbines_brochure.pdf",
    "windturbines_faqs.pdf",
    "<strong>The Provin 15Kw Wind Turbine will provide you with approximately 70% of your annual electricty needs</strong>.",
    "60,60,60,80,60,60,70,80,90,90,80,80",    
    55000,
    2,
    @A
);


/*----------------------------------------------------------------------------------------------------------*/
/* INSERT SERVICE DATA                                                                                      */
/*----------------------------------------------------------------------------------------------------------*/
CALL sp_insert_service(
    "BER Assessments",
    "<p><strong>Building Energy Rating (BER)</strong>is similar to the energy label on a fridge with a scale of A to G. A rated homes are the most energy efficient and G rated ones A are the least efficient.<br/><br/><strong>Renew Energy</strong> will provide an independent registered BER Assessor who has been trained under the National Framework of Qualifications and is registered with Sustainable Energy Ireland.<br/><br/><strong>A BER Certificate</strong> is compulsory for all new homes for which planning permission was applied from 1 January 2007 and for homes for sale or rent from 1 January 2009. Along with a BER Certificate, we will also provide you with an Advisory Report, which will help you to identify ways of improving the energy performance of your home.<br/><br/><span class='content_sub_title'>Case Study</span><br/><br/><strong>House Type : 3 Bed Semi-Detached House built in 1994</strong><br/><br/>A Building Energy Rating was conducted from which the following results were determined.<br/><br/><strong>Before</strong><br/><br/>Rating: 277.77kWh/m&#178;/y - D2<br/>Annual Energy Costs:&nbsp; &#8364;1029.12<br/><br/>Steps were then taken to improve the energy performance of the dwelling as recommended by the Advisory Report which accompanies our BER Certificate.<br/><br/><strong>Result After</strong><br/><br/>Rating: 165.08kWh/m&#178;/y - C1<br/>Annual Energy Costs:&nbsp; &#8364;643.20<br/><br/><strong>Total Savings</strong><br/><br/>Annual Energy Savings:&nbsp; &#8364;385.92<br/>Annual Energy Saving: 38%</p>",
    "berassessments_overviewimage.jpg",
    "berassessments_bannerimage.jpg",
    "berassessments_listimage.jpg",
    150,
    10000,
    @A
);

CALL sp_insert_service(
    "Planning Consultancy",
    "<p>With the introduction of ever changing regulations, materials, methods of building, energy saving technologies and the current economic difficulties, <strong>Renew Energy</strong> recognise that you, more than ever, need clear, professional and impartial advice in relation to all these matters.<br/><br/>We aim to provide you with a home that you can be involved in from the very outset right through to completion.<strong>We can offer you a diverse and varied range of services for your home</strong>. <br/><br/>Not only do we offer design and planning for the current regulation standard construction, we also offer design and planning for more specialised construction methods such as the <strong>Passive House (PassivHaus) standard</strong>.<br/><br/>The Passive House (PassivHaus) requires superior design and components with respect to orientation, layout, external envelope, air tightness, windows, ventilation with heat recovery and innovative heating technologies ...<br/><br/><br/>With our <strong>experienced, qualified and registered Architectural Team</strong>, we can offer a unique range of architectural & building services specialising in Off-grid Low-energy Smart buildings, incorporating the latest systems, methods, building and renewable technologies.<br/><br/>Our design team can work with you to ensure your home is not only designed to meet your needs and lifestyle, but also to meet the essential criteria for the A Rating and/or Passive House (PassivHaus) standard.</p><br/><div class='content_sub_title' style='margin-left: 0px;'>Qualified Consultants</div><p>We have qualified senior Town Planners, who have a wide ranging portfolio of expertise from residential, retail, wind farm, commercial, educational to community led developments. As a result, he provides effective advice to guide clients through the legal framework and policy requirements of the Irish planning system.<br/><br/>Our core work includes planning applications and appeals, as well as development potential reports and planning appraisals for both large and small scale developments.</p><br/> <strong>INITIAL CONSULTATION IS FREE !!!</strong>",
    "planningconsultancy_overviewimage.jpg",
    "planningconsultancy_bannerimage.jpg",
    "planningconsultancy_listimage.jpg",
    250,
    10000,
    @A
);


CALL sp_insert_service(
    "Site Surveys",
    "<p>If you have ever thought that renewable energy products could be a great way to save hundreds, or thousands, of Euro on your energy bills every year, but never really knew where, or how, to get started, <br/><br/><strong>Renew Energy can help...</strong><br/><br/>A <strong>Renew Energy</strong> professional energy expert will come to your home or office to conduct a site survey and explain how and where you can install renewable energy products to help reduce your monthly and annual bills, sometimes by as much as 100%.<br/><br/></p><div class='content_sub_title' style='margin-left: 0px;'>Site Survey's Include The Following, and more ...</div><p><br/><strong>(1) Examination of your electric and or heating bills.<br/><br/>(2) Survey of your site to determine if renewable energy will work for you.<br/><br/>(3) Site Surveys for Solar Electric (PV), Solar Thermal, and Wind Energy.</strong><br/><br/>The price of your site survey will be applied to a Solar Hot Water, Wind Energy or Solar Electric System should you choose to buy one from SEI after your Site Survey is carried out.<br/><br/>We can offer you a wealth of information, experience, services and a product range that will guarantee a solution that meets <strong>your needs</strong> ..<br/><br/>Initially we will carry out a desktop survey and have a conversation to confirm the potential viability of your project. We will review existing data and information about the site – size, processes used, energy spend, bill information, types of meters, who is responsible for the energy management, the organisation's energy management strategy, savings targets, any other planned changes related to energy usage. etc <br/><br/>Following this we will carry out a site survey, analysing and evaluating the site and premises for an energy monitoring and targeting system. The site survey phase is vitally important to help us develop a good understanding of the site activities and to ensure that the installation phase can be completed with the minimum of interruption.<br/><br/>All site surveys are carried out by experienced staff who will look at every aspect of the site activities and energy usage and how they inter-relate. Photographs are typically taken during the site survey to support future recommendations and clarify any obvious queries or issues.</p>",
    "sitesurveys_overviewimage.jpg",
    "sitesurveys_bannerimage.jpg",
    "sitesurveys_listimage.jpg",
    200,
    10000,
    @A
);


/*----------------------------------------------------------------------------------------------------------*/
/* INSERT USER DATA                                                                                         */
/*----------------------------------------------------------------------------------------------------------*/
CALL sp_insert_user(
    "Paul",
    "Millar",
    "74 Slievfoy Park",
    "Muirhevna Mor",
    "Dundalk",
    "Louth",
    "Republic of Ireland",
    null,
    "pm@gmail.com",
    "password",
    1,
    @A
);

CALL sp_insert_user(
    "Joanne",
    "Mulroy",
    "55 olde road",
    null,
    "Ardee",
    "Louth",
    "Republic of Ireland",
    null,
    "jm@gmail.com",
    "password",
    2,
    @A
);

CALL sp_insert_user(
    "Alan",
    "Green",
    "28 Foye Park",
    null,
    "Dublin",
    "Dubin 4",
    "Republic of Ireland",
    null,
    "ag@gmail.com",
    "password",
    2,
    @A
);

CALL sp_insert_user(
    "Mary",
    "Molloy",
    "34 Aghameen Road",
    "St Joes Park",
    "Maynooth",
    "Kildare",
    "Republic of Ireland",
    null,
    "mm@gmail.com",
    "password",
    2,
    @A
);

 
/*----------------------------------------------------------------------------------------------------------*/
/* INSERT ORDER DATA                                                                                        */
/*----------------------------------------------------------------------------------------------------------*/
CALL `sp_insert_order`(1,@a);   
CALL `sp_insert_order`(1,@a);   
CALL `sp_insert_order`(2,@a); 

/*----------------------------------------------------------------------------------------------------------*/
/* INSERT ORDER DATA                                                                                        */
/*----------------------------------------------------------------------------------------------------------*/
CALL `sp_insert_order_item`(
    1,
    1,
    2,
    5500,
    @a
);

CALL `sp_insert_order_item`(
    1,
    4,
    200,
    60,
    @a
);

CALL `sp_insert_order_item`(
    2,
    9,
    1,
    55000,
    @a
);

CALL `sp_insert_order_item`(
    3,
    7,
    1,
    6000,
    @a
);

CALL `sp_insert_order_item`(
    3,
    6,
    150,
    70,
    @a
);