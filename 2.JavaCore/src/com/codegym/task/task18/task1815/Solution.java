package com.codegym.task.task18.task1815;

import java.util.List;

/* 
Table
*/

public class Solution {

    public class TableInterfaceWrapper implements TableInterface {
        TableInterface table;

        public TableInterfaceWrapper(TableInterface table) {
            this.table = table;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            table.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return table.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            table.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}





