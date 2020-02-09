package com.mikhail.ticket;

import com.mikhail.crudBase.BaseEntityFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketFilter extends BaseEntityFilter {

    private Long movieSessionId;
    private Long userId;

}
