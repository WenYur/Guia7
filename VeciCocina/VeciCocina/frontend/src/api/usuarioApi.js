import axios from "axios";

const API_URL = "http://localhost:8080/api/usuarios";

export const obtenerUsuarios = () =>
axios.get(API_URL);

export const crearUsuario = (usuario) =>
axios.post(API_URL, usuario);

export const eliminarUsuario = (id) =>
axios.delete(`${API_URL}/${id}`);

export const asignarTransporte = (usuarioId, transporteId) =>
axios.patch(`${API_URL}/${usuarioId}/transporte/${transporteId}`);

export const asignarReceta = (usuarioId, recetaId) =>
axios.patch(`${API_URL}/${usuarioId}/receta/${recetaId}`);