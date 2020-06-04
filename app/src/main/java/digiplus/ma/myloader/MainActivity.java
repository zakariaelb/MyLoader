package digiplus.ma.myloader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<List<Employee>> {
    EmployeeAdapter empAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        empAdapter = new EmployeeAdapter(this, new ArrayList<Employee>());
        ListView employeeListView = (ListView) findViewById(R.id.employees);
        employeeListView.setAdapter(empAdapter);
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();
    }
    @Override
    public Loader<List<Employee>> onCreateLoader(int id, Bundle args) {
        return new EmployeeLoader(MainActivity.this);
    }
    @Override
    public void onLoadFinished(Loader<List<Employee>> loader, List<Employee> data) {
        empAdapter.setEmployees(data);
    }
    @Override
    public void onLoaderReset(Loader<List<Employee>> loader) {
        empAdapter.setEmployees(new ArrayList<Employee>());
    }
}