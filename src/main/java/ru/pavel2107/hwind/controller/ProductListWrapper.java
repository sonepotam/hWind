package ru.pavel2107.hwind.controller;

import ru.pavel2107.hwind.dto.ProductDTO;
import ru.pavel2107.hwind.model.Product;

import java.util.List;

/**
 * Created by pavel2107 on 01.04.16.
 */
public class ProductListWrapper {

        int iTotalRecords;

        int iTotalDisplayRecords;

        String sEcho;

        String sColumns;

        List<ProductDTO> aaData;

        public int getiTotalRecords() {
            return iTotalRecords;
        }

        public void setiTotalRecords(int iTotalRecords) {
            this.iTotalRecords = iTotalRecords;
        }

        public int getiTotalDisplayRecords() {
            return iTotalDisplayRecords;
        }

        public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
            this.iTotalDisplayRecords = iTotalDisplayRecords;
        }

        public String getsEcho() {
            return sEcho;
        }

        public void setsEcho(String sEcho) {
            this.sEcho = sEcho;
        }

        public String getsColumns() {
            return sColumns;
        }

        public void setsColumns(String sColumns) {
            this.sColumns = sColumns;
        }

        public List<ProductDTO> getAaData() {
            return aaData;
        }

        public void setAaData(List<ProductDTO> aaData) {
            this.aaData = aaData;
        }


    }

