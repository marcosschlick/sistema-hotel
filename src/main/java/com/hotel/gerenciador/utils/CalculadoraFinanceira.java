package com.hotel.gerenciador.utils;

import com.hotel.gerenciador.models.Reserva;
import com.hotel.gerenciador.services.PagamentoService;
import com.hotel.gerenciador.services.ConsumoService;
import com.hotel.gerenciador.services.ConsumoServicosService;
import java.math.BigDecimal;

public class CalculadoraFinanceira {
    private final PagamentoService pagamentoService;
    private final ConsumoService consumoService;
    private final ConsumoServicosService consumoServicosService;

    public CalculadoraFinanceira(PagamentoService pagamentoService, 
                                ConsumoService consumoService,
                                ConsumoServicosService consumoServicosService) {
        this.pagamentoService = pagamentoService;
        this.consumoService = consumoService;
        this.consumoServicosService = consumoServicosService;
    }

    public BigDecimal calcularTotalPagoParaReserva(int reservaId) {
        return pagamentoService.calcularTotalPagoParaReserva(reservaId);
    }

    public BigDecimal calcularTotalProdutoConsumos(int reservaId) {
        return consumoService.calcularTotalConsumos(reservaId);
    }

    public BigDecimal calcularTotalServicoConsumos(int reservaId) {
        return consumoServicosService.calcularTotalConsumos(reservaId);
    }

    public BigDecimal calcularSaldoDevedorReserva(Reserva reserva) {
        if (reserva == null) return BigDecimal.ZERO;
        
        BigDecimal totalPago = calcularTotalPagoParaReserva(reserva.getId());
        BigDecimal totalConsumos = calcularTotalProdutoConsumos(reserva.getId())
            .add(calcularTotalServicoConsumos(reserva.getId()));
        BigDecimal valorReserva = reserva.getValorTotal();
        
        return valorReserva.add(totalConsumos).subtract(totalPago);
    }
} 