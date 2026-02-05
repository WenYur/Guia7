import { useEffect, useState } from "react";
import { obtenerFacturas, eliminarFactura } from "../../api/facturaApi";

export default function FacturaList({ refrescar }) {
  const [facturas, setFacturas] = useState([]);

  const cargarFacturas = async () => {
    const res = await obtenerFacturas();
    setFacturas(res.data);
  };

  useEffect(() => {
    cargarFacturas();
  }, [refrescar]);

  const borrar = async (id) => {
    await eliminarFactura(id);
    cargarFacturas();
  };

  return (
    <div>
      <h3>Facturas</h3>

      <ul>
        {facturas.map((f) => (
          <li key={f.id}>
            <strong>ID:</strong> {f.id_Factura} | 
            <strong> Total:</strong> ${f.total}
            <strong>Inventario:</strong>{" "}
            {f.inventario ? f.inventario.id_Inventario : "No asignado"}
            <button onClick={() => borrar(f.id_Factura)}>❌</button>
          </li>
        ))}
      </ul>
           
    </div>
  );
}