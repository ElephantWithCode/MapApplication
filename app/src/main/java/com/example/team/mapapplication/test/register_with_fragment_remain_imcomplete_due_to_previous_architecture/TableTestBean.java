package com.example.team.mapapplication.test.register_with_fragment_remain_imcomplete_due_to_previous_architecture;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

@SmartTable(name = "null")
public class TableTestBean {
    public TableTestBean(String x, String y){
        this.x = x;
        this.y = y;
    }
    @SmartColumn(id = 0, name = "x")
    private String x;
    @SmartColumn(id = 1, name = "y")
    private String y;
}
