import { useState } from "react";
import FacturaForm from "../components/facturas/FacturaForm";
import FacturaList from "../components/facturas/FacturaList";
import AsignarInventario from "../components/facturas/AsignarInventario";

export default function FacturasPage() {
  const [refrescar, setRefrescar] = useState(false);
    const recargarFacturas = async () => {
    setRefrescar((prev) => !prev);
    };
  
return (
    <div>
      <h2>Gestión de Facturas</h2>
      <FacturaForm onFacturaCreada={() => setRefrescar(!refrescar)} />
      <AsignarInventario onAsignado={recargarFacturas} />
      <FacturaList refrescar={refrescar} />
    </div>
  );
}