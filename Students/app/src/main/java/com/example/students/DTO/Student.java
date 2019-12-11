package com.example.students.DTO;

public class Student {
    public Student(String _mssv, String _name) {
        this._mssv = _mssv;
        this._name = _name;
    }

    public String get_mssv() {
        return _mssv;
    }

    public void set_mssv(String _mssv) {
        this._mssv = _mssv;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    private  String _mssv;
    private  String _name;


}
