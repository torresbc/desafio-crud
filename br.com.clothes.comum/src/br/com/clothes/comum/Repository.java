package br.com.clothes.comum;

public enum Repository {
    SQL(0), MySQL(1), Oracle(2), PostgreSQL(3), Access(4),
    FileExcel(5), FileTXT(6);

    int idRepository;

    Repository(int idRepository) {
        this.idRepository = idRepository;
    }
}
