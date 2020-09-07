package br.com.clothes.business;

import br.com.clothes.comum.Repository;

public class Config {

    private static Config uniqueInstance;

    private Config() {
    }

    public static synchronized Config getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Config();

        return uniqueInstance;
    }

    private Repository repositoryType;

    public Repository getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(Repository repositoryType) {
        this.repositoryType = repositoryType;
    }
}
