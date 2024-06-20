package com.myapplication.projetopoo2324.atividade;
import com.myapplication.projetopoo2324.atividade.Atividade; 
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.distancia.Distancia; 
/**
 *
 * @author tomas
 */
public void testAtividadeSerialization() {
    Atividade original = new Distancia("Teste", TipoAtividade.DISTANCIA, 100, 5, 12.0, LocalDateTime.now(), false);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        oos.writeObject(original);
    } catch (IOException e) {
        fail("Serialization failed: " + e.getMessage());
    }

    Atividade deserialized = null;
    try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
        deserialized = (Atividade) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        fail("Deserialization failed: " + e.getMessage());
    }

    assertEquals("Teste", deserialized.getNome());
    assertEquals(5, deserialized.getIteracoes());
}
