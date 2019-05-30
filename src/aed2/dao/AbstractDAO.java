package aed2.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.List;

/**
 * Implementação de DAO para arquivo.
 */
public abstract class AbstractDAO<T> implements DAO {

    /**
     * Constrói o objeto (no nosso caso Pessoa).
     */
    protected abstract T factory(List args);

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(long id) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        do {
            String line = bufferedReader.readLine();
            List args = List.of(line.split("\\;"));
            if (Long.getLong(args.get(0)) == id) {
                fileReader.close();
                return factory(args);
            }
        } while (line != null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> get() throws IOException {
	    FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<T> list = new ArrayList<>();
        do {
            String line = bufferedReader.readLine();
            List args = List.of(line.split("\\;"));
            list.add(factory(args));
        } while (line != null);
        fileReader.close();
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(T item) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer inputBuffer = new StringBuffer();
        do {
            String line = readLine();
            List args = List.of(line.split("\\;"));
            if (item.id() == Long.parseLong(args.get(0))) {
                inputBuffer.append(item.toData() + "\n");
            } else {
                inputBuffer.append(line + "\n");                
            }
        } while (line != null);
        fileReader.close();
        FileOutputStream fileStream = new FileOutputStream(fileName);
        OutputStreamWriter outputWriter = new OutputStreamWriter(fileStream);
        BufferedWriter bufferredWriter = new BufferedWriter(outputWriter);
        bufferredWriter.write(inputBuffer.toString().getBytes());
        bufferredWriter.newLine();
        fileStream.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(T item) throws IOException {
        FileOutputStream fileStream = new FileOutputStream(fileName, true);
        OutputStreamWriter outputWriter = new OutputStreamWriter(fileStream);
        BufferedWriter bufferredWriter = new BufferedWriter(outputWriter);
        bufferredWriter.write(item.toData());
        bufferredWriter.newLine();
        fileStream.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(long id) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer inputBuffer = new StringBuffer();
        do {
            String line = readLine();
            List args = List.of(line.split("\\;"));
            if (id != Long.parseLong(args.get(0))) {
                inputBuffer.append(line + "\n");               
            }
        } while (line != null);
        fileReader.close();
        FileOutputStream fileStream = new FileOutputStream(fileName);
        OutputStreamWriter outputWriter = new OutputStreamWriter(fileStream);
        BufferedWriter bufferredWriter = new BufferedWriter(outputWriter);
        bufferredWriter.write(inputBuffer.toString().getBytes());
        bufferredWriter.newLine();
        fileStream.close();
    }
}