package com.solar4america.service.ticket.api;

import com.solar4america.entity.TicketDBO;

import java.util.List;

public interface ITicketApi {
    public List<TicketDBO> listRecords(TicketDBO ticketDBO);
    public int saveAndEditTicket(TicketDBO ticketDBO);

    public TicketDBO getTicket(Integer ticketId);
}
