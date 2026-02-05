import { useState } from "react";
import { crearFactura } from "../../api/facturaApi";

export default function FacturaForm({ onFacturaCreada }) {
  const [total, setTotal] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const factura = {
      total: Number(total),
      inventario: null,
      pagos: null
    };

    await crearFactura(factura);
    setTotal("");
    onFacturaCreada();
    };

    return (
    <form onSubmit={handleSubmit}>
        <h3>Nueva Factura</h3>

      <input
        type="number"
        value={total}
        onChange={(e) => setTotal(e.target.value)}
        placeholder="Total"
        required
      />

      <button type="submit">Guardar</button>
    </form>
  );
}