DROP INDEX PK_PRODUCT;

/* 상품 */
DROP TABLE PRODUCT 
	CASCADE CONSTRAINTS;

/* 상품 */
CREATE TABLE PRODUCT (
	PNUM NUMBER(8) NOT NULL, /* 상품번호 */
	DOWNCG_CODE NUMBER(8), /* 하위카테고리코드 */
	UPCG_CODE NUMBER(8), /* 상위카테고리코드 */
	PNAME VARCHAR2(50) NOT NULL, /* 상품명 */
	PIMAGE1 VARCHAR2(50), /* 이미지1 */
	PIMAGE2 VARCHAR2(50), /* 이미지2 */
	PIMAGE3 VARCHAR2(50), /* 이미지3 */
	PRICE NUMBER(8) NOT NULL, /* 상품정가 */
	SALEPRICE NUMBER(8), /* 상품판매가 */
	PQTY NUMBER(8), /* 상품수량 */
	POINT NUMBER(8), /* 포인트 */
	PSEEC VARCHAR2(20), /* 스펙 */
	PCONTENTS VARCHAR2(1000), /* 상품설명 */
	PCOMPANY VARCHAR2(50), /* 제조사 */
	PINDATE DATE /* 등록일 */
);

CREATE UNIQUE INDEX PK_PRODUCT
	ON PRODUCT (
		PNUM ASC
	);

ALTER TABLE PRODUCT
	ADD
		CONSTRAINT PK_PRODUCT
		PRIMARY KEY (
			PNUM
		);

ALTER TABLE PRODUCT
	ADD
		CONSTRAINT FK_DOWNCATEGORY_TO_PRODUCT
		FOREIGN KEY (
			DOWNCG_CODE,
			UPCG_CODE
		)
		REFERENCES DOWNCATEGORY (
			DOWNCG_CODE,
			UPCG_CODE
		);

ALTER TABLE PRODUCT
	ADD
		CONSTRAINT FK_UPCATEGORY_TO_PRODUCT
		FOREIGN KEY (
			UPCG_CODE
		)
		REFERENCES UPCATEGORY (
			UPCG_CODE
		);
		
create sequence product_seq nocache;