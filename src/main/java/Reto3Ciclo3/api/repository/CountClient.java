package Reto3Ciclo3.api.repository;

import Reto3Ciclo3.api.model.Client;

/**
 *
 * @author LGUACANEMEMT
 */

public class CountClient {
    private Long total;
    private Client client;

    /**
     *
     * @param total
     * @param client
     */
    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
